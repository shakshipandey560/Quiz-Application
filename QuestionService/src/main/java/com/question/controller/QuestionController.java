package com.question.controller;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;
    
    @PostMapping("/createQuestion")
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }
    
    @GetMapping("/getQuestionById/{id}")
    public Question getQuestion(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }
    
    @GetMapping("/getAllData")
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestions();
    }
    
    @GetMapping("/getQuestionOfQuiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }
     
}
