package com.grosshaeuser.ai_panel.mapper;

import com.grosshaeuser.ai_panel.dtos.AgentSessionDTO;
import com.grosshaeuser.ai_panel.models.Agent;
import com.grosshaeuser.ai_panel.models.AgentSession;
import org.springframework.stereotype.Component;

@Component
public class AgentSessionMapper {

    public AgentSessionDTO mapAgentSessionToDTO(AgentSession agentSession) {
        return new AgentSessionDTO(agentSession.getId(), agentSession.getAgent().getId(), agentSession.getSessionId());
    }

    public AgentSession mapDTOToAgentSession(Agent agent, AgentSessionDTO agentSessionDTO) {
        return new AgentSession(agentSessionDTO.getId(), agent, agentSessionDTO.getSessionId());
    }

}
