package com.dhananjaya.AI_Study_Buddy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DataIngestionService {

    private static final Logger log = LoggerFactory.getLogger(DataIngestionService.class);
    private final VectorStore vectorStore;

    public DataIngestionService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public void ingest(Resource pdfResource) {
        log.info("STARTING: Parsing PDF...");

        PagePdfDocumentReader pdfReader = new PagePdfDocumentReader(pdfResource);
        TokenTextSplitter textSplitter = new TokenTextSplitter();
        var documents = textSplitter.apply(pdfReader.get());

        vectorStore.accept(documents);

        if (vectorStore instanceof SimpleVectorStore simpleStore) {
            simpleStore.save(new File("vectorstore.json"));
        }

        log.info("DONE: Document stored in Vector Database!");
    }
}