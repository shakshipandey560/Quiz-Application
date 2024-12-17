package com.question.service;

import com.question.entities.Question;
import java.util.List;

public interface QuestionService {
    
    Question createQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    List<Question> getQuestionsOfQuiz(Long quizId);
    
}
