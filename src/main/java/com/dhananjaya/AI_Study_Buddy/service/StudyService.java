package com.dhananjaya.AI_Study_Buddy.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class StudyService {

    private final ChatClient  chatClient;

    public StudyService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("You are a helpful, patient tutor for an intern-level student. " +
                        "Explain things clearly, use analogies, and keep answers concise. " +
                        "If the user asks for code, provide a simple Java example.")
                // We use 'InMemoryChatMemory' which stores history in a simple Java List
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    public String explainTopic(String topic) {
        return chatClient.prompt()
                .user("Please explain the concept of: " + topic)
                .call()
                .content();
    }
}
