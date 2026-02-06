package com.dhananjaya.AI_Study_Buddy.controller;

import com.dhananjaya.AI_Study_Buddy.service.StudyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/study")
public class StudyController {

    private final StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping("/ask")
    public String askTutor(@RequestParam String topic) {
        return studyService.explainTopic(topic);
    }
}
