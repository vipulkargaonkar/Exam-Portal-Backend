package com.examportal.repository;

import com.examportal.entity.CategoryEntity;
import com.examportal.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {

    public List<QuizEntity> findByCategory(CategoryEntity category);

    public List<QuizEntity> findByActive(Boolean value);

    public List<QuizEntity> findByCategoryAndActive(CategoryEntity category, Boolean value);
}
