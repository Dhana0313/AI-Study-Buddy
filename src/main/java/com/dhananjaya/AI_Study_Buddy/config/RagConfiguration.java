package com.dhananjaya.AI_Study_Buddy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class RagConfiguration {

    private static final Logger log = LoggerFactory.getLogger(RagConfiguration.class);

    @Bean
    public VectorStore vectorStore(EmbeddingModel embeddingModel) {

        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(embeddingModel).build();

        File vectorStoreFile = new File("src/main/resources/vectorstore.json");

        if (vectorStoreFile.exists()) {
            simpleVectorStore.load(vectorStoreFile);
            log.info("Loaded existing Vector Store from file.");
        } else {
            log.info("Created new empty Vector Store.");
        }

        return simpleVectorStore;
    }
}