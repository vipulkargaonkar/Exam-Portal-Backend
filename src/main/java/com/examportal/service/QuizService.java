package com.examportal.service;

import com.examportal.entity.QuizEntity;

import java.util.Set;

public interface QuizService {

    public QuizEntity addQuiz(QuizEntity quiz);

    public QuizEntity updateQuiz(QuizEntity quiz);

    public Set<QuizEntity> getQuizzes();

    public QuizEntity getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);

}
