package com.examportal.service.impl;

import com.examportal.entity.CategoryEntity;
import com.examportal.entity.QuizEntity;
import com.examportal.repository.QuizRepository;
import com.examportal.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public QuizEntity addQuiz(QuizEntity quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public QuizEntity updateQuiz(QuizEntity quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<QuizEntity> getQuizzes() {
        return new LinkedHashSet<>(quizRepository.findAll());
    }

    @Override
    public QuizEntity getQuiz(Long quizId) {
        return quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }

    @Override
    public List<QuizEntity> getQuizzesOfCategory(CategoryEntity category) {
        return quizRepository.findByCategory(category);
    }

    @Override
    public List<QuizEntity> getActiveQuizzes() {
        return quizRepository.findByActive(Boolean.TRUE);
    }

    @Override
    public List<QuizEntity> getActiveQuizzesOfCategory(CategoryEntity category) {
        return quizRepository.findByCategoryAndActive(category, Boolean.TRUE);
    }
}
