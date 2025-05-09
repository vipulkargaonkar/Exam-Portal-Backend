package com.examportal.controller;

import com.examportal.entity.CategoryEntity;
import com.examportal.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryEntity> addCategory(@RequestBody CategoryEntity category) {
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @GetMapping("/{categoryId}")
    public CategoryEntity getCategory(@PathVariable("categoryId") Long categoryId) {
        return this.categoryService.getCategory(categoryId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PutMapping("/")
    public CategoryEntity updateCategory(@RequestBody CategoryEntity category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
