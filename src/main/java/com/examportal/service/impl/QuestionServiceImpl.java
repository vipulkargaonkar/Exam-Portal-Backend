package com.examportal.service.impl;

import com.examportal.entity.QuestionEntity;
import com.examportal.entity.QuizEntity;
import com.examportal.repository.QuestionRepository;
import com.examportal.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionEntity addQuestion(QuestionEntity question) {
        return questionRepository.save(question);
    }

    @Override
    public QuestionEntity updateQuestion(QuestionEntity question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<QuestionEntity> getQuestions() {
        return new LinkedHashSet<>(questionRepository.findAll());
    }

    @Override
    public QuestionEntity getQuestion(Long questionId) {
        return questionRepository.findById(questionId).get();
    }

    @Override
    public Set<QuestionEntity> getQuestionsOfQuiz(QuizEntity quiz) {
        return questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        questionRepository.deleteById(quesId);
    }
}
