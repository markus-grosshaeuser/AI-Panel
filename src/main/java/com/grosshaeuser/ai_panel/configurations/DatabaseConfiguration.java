package com.grosshaeuser.ai_panel.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.grosshaeuser.ai_panel.repositories.jpa")
@EnableMongoRepositories(basePackages = "com.grosshaeuser.ai_panel.repositories.mongodb")
public class DatabaseConfiguration {
}
