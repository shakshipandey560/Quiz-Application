package com.question.service.impl;

import com.question.entities.Question;
import com.question.repositories.QuestionRepositories;
import com.question.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    
    private QuestionRepositories questionRepositories;

    public QuestionServiceImpl(QuestionRepositories questionRepositories) {
        this.questionRepositories = questionRepositories;
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepositories.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepositories.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepositories.findById(id).orElseThrow(()->new RuntimeException("Question Not Found!!"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepositories.findByQuizId(quizId);
    }
}
