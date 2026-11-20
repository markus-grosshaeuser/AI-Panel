package com.grosshaeuser.ai_panel.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentSessionDTO {
    private Long id;
    private Long agentId;
    private String sessionId;
}
