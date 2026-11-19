package com.grosshaeuser.ai_panel.mapper;

import com.grosshaeuser.ai_panel.dtos.AgentDTO;
import com.grosshaeuser.ai_panel.models.Agent;
import com.grosshaeuser.ai_panel.models.User;
import com.grosshaeuser.ai_panel.repositories.jpa.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper {

    private final UserRepository userRepository;

    public AgentMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static AgentDTO mapAgentToDTO(Agent agent) {
        return new AgentDTO(agent.getId(), agent.getUser().getId(), agent.getName(), agent.getSystemPrompt(), agent.getImage());
    }

    public Agent mapDTOToAgent(AgentDTO agentDTO) {
        User user = userRepository.findById(agentDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + agentDTO.getUserId()));

        return Agent.builder()
                .id(agentDTO.getId())
                .user(user)
                .name(agentDTO.getName())
                .systemPrompt(agentDTO.getSystemPrompt())
                .image(agentDTO.getImage())
                .build();
    }

}