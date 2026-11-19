package com.grosshaeuser.ai_panel.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatResponse {
    private String message;
    private boolean success;
    private String error;
}
