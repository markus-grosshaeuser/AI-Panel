package com.grosshaeuser.ai_panel.repositories.mongodb;

import com.grosshaeuser.ai_panel.models.ChatSession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatSessionRepository extends MongoRepository<ChatSession, String> {

}
