package com.dhananjaya.AI_Study_Buddy.service;

import com.dhananjaya.AI_Study_Buddy.entity.QuizResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
public class StudyService {

    private final ChatClient chatClient;

    // We inject the VectorStore so the bot can search it
    public StudyService(ChatClient.Builder builder, VectorStore vectorStore) {
        this.chatClient = builder
                .defaultSystem("You are a helpful, patient tutor. " +
                        "If the user asks about a specific document, use the context provided to answer. " +
                        "If the answer is not in the context, say 'I couldn't find that in your notes'.")
                .defaultAdvisors(
                        // 1. Memory (So it remembers your name)
                        new MessageChatMemoryAdvisor(new InMemoryChatMemory()),

                        // 2. RAG (Retrieval Augmented Generation)
                        // This searches your Vector Store for the top 4 most relevant chunks
                        new QuestionAnswerAdvisor(vectorStore, SearchRequest.builder().build())
                )
                .build();
    }

    public String explainTopic(String topic) {
        return chatClient.prompt()
                .user(topic)
                .call()
                .content();
    }

    public QuizResponse getQuiz(String topic) {
        return chatClient.prompt()
                .user("Generate a strictly single multiple-choice question about: " + topic +
                        ". The audience is an intern-level developer.")
                .call()
                .entity(QuizResponse.class);
    }
}
