package com.dhananjaya.AI_Study_Buddy.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class StudyService {

    private final ChatClient  chatClient;

    public StudyService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("You are a helpful, patient tutor for an intern-level student. " +
                        "Explain things clearly, use analogies, and keep answers concise. " +
                        "If the user asks for code, provide a simple Java example.")
                .build();
    }

    public String explainTopic(String topic) {
        return chatClient.prompt()
                .user("Please explain the concept of: " + topic)
                .call()
                .content();
    }
}
