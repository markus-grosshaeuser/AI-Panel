package com.grosshaeuser.ai_panel.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agent_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id", nullable = false)
    private Agent agent;

    @Column(name = "session_id", nullable = false, unique = true, length = 50)
    private String sessionId;

}
