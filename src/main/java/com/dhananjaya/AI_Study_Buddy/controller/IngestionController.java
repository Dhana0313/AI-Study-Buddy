package com.dhananjaya.AI_Study_Buddy.controller;

import com.dhananjaya.AI_Study_Buddy.service.DataIngestionService;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/ingest")
public class IngestionController {

    private final DataIngestionService ingestionService;

    public IngestionController(DataIngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping
    public String ingestPdf(@RequestParam("file") MultipartFile file) {
        // Convert the uploaded file into a Spring Resource
        Resource resource = file.getResource();

        try {
            ingestionService.ingest(resource);
            return "✅ Success! I have read and learned from your PDF.";
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }
}