package com.grosshaeuser.ai_panel.repositories.jpa;

import com.grosshaeuser.ai_panel.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    List<Agent> findByUserIdOrderByNameAsc(Long userId);
}
