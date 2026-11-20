package com.grosshaeuser.ai_panel.repositories.jpa;

import com.grosshaeuser.ai_panel.models.AgentSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgentSessionRepository extends JpaRepository<AgentSession, Long> {
    List<AgentSession> findByAgentIdAndAgentUserId(Long agentId, Long userId);

    Optional<AgentSession> findBySessionId(String sessionId);

    boolean existsByAgentIdAndSessionId(Long agentId, String sessionId);
}
