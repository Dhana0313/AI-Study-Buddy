package com.dhananjaya.AI_Study_Buddy.entity;

import java.util.List;

// This defines exactly what we want the AI to give us
public record QuizResponse(
        String question,
        List<String> options,
        String correctAnswer
) {}
