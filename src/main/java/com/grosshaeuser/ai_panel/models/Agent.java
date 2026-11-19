package com.grosshaeuser.ai_panel.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agents", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "name"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String systemPrompt;

    private byte[] image;

}
