package com.examportal.service.impl;

import com.examportal.entity.CategoryEntity;
import com.examportal.repository.CategoryRepository;
import com.examportal.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity addCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public Set<CategoryEntity> getCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public CategoryEntity getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }
}
