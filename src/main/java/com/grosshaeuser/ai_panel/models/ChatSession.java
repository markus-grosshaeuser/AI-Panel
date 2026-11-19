package com.grosshaeuser.ai_panel.models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "chat_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatSession {
    @Id
    private String id;
    private String userId;

    private String title;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<ChatMessage> messages;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ChatMessage {
        private String role;
        private String content;
        private LocalDateTime timestamp;
    }
}
