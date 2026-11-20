package com.grosshaeuser.ai_panel.services.impl;

import com.grosshaeuser.ai_panel.dtos.AgentDTO;
import com.grosshaeuser.ai_panel.dtos.AgentSessionDTO;
import com.grosshaeuser.ai_panel.mapper.AgentMapper;
import com.grosshaeuser.ai_panel.mapper.AgentSessionMapper;
import com.grosshaeuser.ai_panel.models.User;
import com.grosshaeuser.ai_panel.repositories.jpa.AgentRepository;
import com.grosshaeuser.ai_panel.repositories.jpa.AgentSessionRepository;
import com.grosshaeuser.ai_panel.repositories.jpa.UserRepository;
import com.grosshaeuser.ai_panel.services.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;
    private final AgentSessionRepository agentSessionRepository;
    private final UserRepository userRepository;
    private final AgentMapper agentMapper;
    private final AgentSessionMapper agentSessionMapper;

    @Override
    public void save(AgentDTO agent) {
        User user = userRepository.findById(agent.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + agent.getUserId()));
        agentRepository.save(agentMapper.mapDTOToAgent(user, agent));
    }

    @Override
    public List<AgentDTO> findAgentsByUserId(Long userId) {
        return agentRepository.findByUserIdOrderByNameAsc(userId).stream()
                .map(agentMapper::mapAgentToDTO)
                .toList();
    }

    @Override
    public Optional<AgentDTO> findAgentBySessionId(String id) {
        return agentSessionRepository.findBySessionId(id).map(session -> agentMapper.mapAgentToDTO(session.getAgent()));
    }

    @Override
    public List<AgentSessionDTO> findSessionsByUserIdAndAgentId(Long userId, Long agentId) {
        return agentSessionRepository.findByAgentIdAndAgentUserId(agentId, userId).stream()
                .map(agentSessionMapper::mapAgentSessionToDTO)
                .toList();
    }
}
