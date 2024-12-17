package com.quiz.service.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepositories;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class QuizServiceImpl implements QuizService {
    
    private QuizRepositories quizRepositories;
    
    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepositories quizRepositories, QuestionClient questionClient) {
        this.quizRepositories = quizRepositories;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepositories.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long id) {
        Quiz quiz = quizRepositories.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionofQuize(quiz.getId()));
        return quiz;
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes = quizRepositories.findAll();

        List<Quiz> newQuizList = quizzes.stream().map(quiz ->{
                quiz.setQuestions(questionClient.getQuestionofQuize(quiz.getId()));
                return quiz;
    }).collect(Collectors.toList());
        return newQuizList;
    }
}
