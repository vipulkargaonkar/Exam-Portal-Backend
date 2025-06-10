package com.examportal.service;

import com.examportal.entity.QuestionEntity;
import com.examportal.entity.QuizEntity;

import java.util.Set;

public interface QuestionService {

    public QuestionEntity addQuestion(QuestionEntity question);

    public QuestionEntity updateQuestion(QuestionEntity question);

    public Set<QuestionEntity> getQuestions();

    public QuestionEntity getQuestion(Long questionId);

    public Set<QuestionEntity> getQuestionsOfQuiz(QuizEntity quiz);

    public void deleteQuestion(Long quesId);

    public QuestionEntity get(Long quesId);
}
