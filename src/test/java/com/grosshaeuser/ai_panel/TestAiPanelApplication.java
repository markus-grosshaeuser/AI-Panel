package com.grosshaeuser.ai_panel;

import org.springframework.boot.SpringApplication;

public class TestAiPanelApplication {

    public static void main(String[] args) {
        SpringApplication.from(AiPanelApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
