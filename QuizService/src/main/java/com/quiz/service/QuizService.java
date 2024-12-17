package com.quiz.service;

import com.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {
    
    Quiz add(Quiz quiz);
    Quiz getQuiz(Long id);
    List<Quiz> getAllQuiz();
}
