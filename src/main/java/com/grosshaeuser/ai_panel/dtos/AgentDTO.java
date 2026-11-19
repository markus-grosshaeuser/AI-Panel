package com.grosshaeuser.ai_panel.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentDTO {
    private Long id;
    private Long userId;
    private String name;
    private String systemPrompt;
    private byte[] image;
}
