package com.examportal.service;

import com.examportal.entity.CategoryEntity;

import java.util.Set;

public interface CategoryService {

    public CategoryEntity addCategory(CategoryEntity category);

    public CategoryEntity updateCategory(CategoryEntity category);

    public Set<CategoryEntity> getCategories();

    public CategoryEntity getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);
}
