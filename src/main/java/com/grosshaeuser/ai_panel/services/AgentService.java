package com.grosshaeuser.ai_panel.services;

import com.grosshaeuser.ai_panel.dtos.AgentDTO;
import com.grosshaeuser.ai_panel.dtos.AgentSessionDTO;

import java.util.List;
import java.util.Optional;

public interface AgentService {

    void save(AgentDTO agent);

    List<AgentDTO> findAgentsByUserId(Long userId);

    Optional<AgentDTO> findAgentBySessionId(String id);

    List<AgentSessionDTO> findSessionsByUserIdAndAgentId(Long userId, Long agentId);
}
