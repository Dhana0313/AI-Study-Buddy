package com.dhananjaya.AI_Study_Buddy;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final ChatClient chatClient;

    public TestController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/test")
    public String test(){
        return chatClient.prompt("Hello Gemini! Are you working?").call().content();
    }
}
