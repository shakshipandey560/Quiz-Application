package com.quiz.service;

import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient (url="http://localhost:8082", value="Question-Client")
@FeignClient (name="QuestionService")
public interface QuestionClient {

    @GetMapping("/question/getQuestionOfQuiz/{quizId}")
    List<Question> getQuestionofQuize(@PathVariable Long quizId);

}
