package com.grosshaeuser.ai_panel.mapper;

import com.grosshaeuser.ai_panel.dtos.AgentDTO;
import com.grosshaeuser.ai_panel.models.Agent;
import com.grosshaeuser.ai_panel.models.User;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper {

    public AgentDTO mapAgentToDTO(Agent agent) {
        return new AgentDTO(agent.getId(), agent.getUser().getId(), agent.getName(), agent.getSystemPrompt(), agent.getImage());
    }

    public Agent mapDTOToAgent(User user, AgentDTO agentDTO) {
        return Agent.builder()
                .id(agentDTO.getId())
                .user(user)
                .name(agentDTO.getName())
                .systemPrompt(agentDTO.getSystemPrompt())
                .image(agentDTO.getImage())
                .build();
    }

}