package com.grosshaeuser.ai_panel.services;

import com.grosshaeuser.ai_panel.models.Agent;
import reactor.core.publisher.Flux;

public interface ChatOrchestrationService {

    String orchestrateChat(Agent agent, String sessionId, String userContent);

    Flux<String> streamChat(Agent agent, String sessionId, String userContent);

}
