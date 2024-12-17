package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public Quiz creat( @RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }
    
    @GetMapping("/getData")
    public List<Quiz> getAll() {
        return quizService.getAllQuiz();
    }
    
    @GetMapping("/getById/{id}")
    public Quiz getById(@PathVariable Long id) {
        return quizService.getQuiz(id);
    }
}
