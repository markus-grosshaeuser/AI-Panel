package com.grosshaeuser.ai_panel.services.impl;

import com.grosshaeuser.ai_panel.models.Agent;
import com.grosshaeuser.ai_panel.models.ChatSession;
import com.grosshaeuser.ai_panel.repositories.mongodb.ChatSessionRepository;
import com.grosshaeuser.ai_panel.services.ChatOrchestrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatOrchestrationServiceImpl implements ChatOrchestrationService {

    private final ChatModel chatModel;
    private final ChatSessionRepository chatSessionRepository;

    @Override
    public String orchestrateChat(Agent agent, String sessionId, String userContent) {
        ChatSession session = fetchOrCreateSession(sessionId);
        Prompt prompt = new Prompt(conversationMessages(agent, session, userContent));
        AssistantMessage assistantResponse = chatModel.call(prompt).getResults().getFirst().getOutput();
        updateSession(session, userContent, assistantResponse.getText());
        return assistantResponse.getText();
    }

    @Override
    public Flux<String> streamChat(Agent agent, String sessionId, String userContent) {
        return Flux.defer(() -> {
            ChatSession session = fetchOrCreateSession(sessionId);
            Prompt prompt = new Prompt(conversationMessages(agent, session, userContent));
            StringBuilder reply = new StringBuilder();
            return chatModel.stream(prompt)
                    .publishOn(Schedulers.boundedElastic())
                    .<String>handle((response, sink) -> {
                        if (response.getResult() != null) {
                            response.getResult();
                            String text = response.getResult().getOutput().getText();
                            if (text != null && !text.isEmpty()) {
                                sink.next(text);
                            }
                        }
                    })
                    .doOnNext(reply::append)
                    .doOnComplete(() -> updateSession(session, userContent, reply.toString()));
        }).subscribeOn(Schedulers.boundedElastic());
    }

    private ChatSession fetchOrCreateSession(String sessionId) {
        return chatSessionRepository.findById(sessionId)
                .orElseGet(() -> {
                    ChatSession newSession = ChatSession.builder()
                            .id(sessionId)
                            .userId("default-user") // Placeholder for now
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .messages(new ArrayList<>())
                            .build();
                    return chatSessionRepository.save(newSession);
                });
    }

    private void updateSession(ChatSession session, String userContent, String assistantContent) {
        session.getMessages().add(ChatSession.ChatMessage.builder()
                .role("user")
                .content(userContent)
                .timestamp(LocalDateTime.now())
                .build());
        session.getMessages().add(ChatSession.ChatMessage.builder()
                .role("assistant")
                .content(assistantContent)
                .timestamp(LocalDateTime.now())
                .build());
        session.setUpdatedAt(LocalDateTime.now());
        chatSessionRepository.save(session);
    }

    private List<Message> conversationMessages(Agent agent, ChatSession session, String userContent) {
        List<Message> messages = new ArrayList<>();
        messages.add(new SystemMessage(agent.getSystemPrompt()));
        for (ChatSession.ChatMessage message : session.getMessages()) {
            if ("user".equalsIgnoreCase(message.getRole())) {
                messages.add(new UserMessage(message.getContent()));
            } else if ("assistant".equalsIgnoreCase(message.getRole())) {
                messages.add(new AssistantMessage(message.getContent()));
            }
        }
        messages.add(new UserMessage(userContent));
        return messages;
    }

}
