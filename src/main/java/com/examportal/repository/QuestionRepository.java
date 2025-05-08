package com.examportal.repository;

import com.examportal.entity.QuestionEntity;
import com.examportal.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    Set<QuestionEntity> findByQuiz(QuizEntity quiz);
}
