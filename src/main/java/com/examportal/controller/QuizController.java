package com.examportal.controller;

import com.examportal.entity.CategoryEntity;
import com.examportal.entity.QuizEntity;
import com.examportal.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/")
    public ResponseEntity<QuizEntity> addQuiz(@RequestBody QuizEntity quiz) {
        return ResponseEntity.ok(quizService.addQuiz(quiz));
    }

    @GetMapping("/{qId}")
    public QuizEntity getQuiz(@PathVariable("qId") Long quizId) {
        return quizService.getQuiz(quizId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuizzes() {
        return ResponseEntity.ok(quizService.getQuizzes());
    }

    @PutMapping("/")
    public ResponseEntity<QuizEntity> updateQuiz(@RequestBody QuizEntity quiz) {
        return ResponseEntity.ok(quizService.updateQuiz(quiz));
    }

    @DeleteMapping("/{qId}")
    public void deleteQuiz(@PathVariable("qId") Long qId) {
        this.quizService.deleteQuiz(qId);
    }

    @GetMapping("/category/{cid}")
    public List<QuizEntity> getQuizzesOfCategory(@PathVariable Long cid) {
        CategoryEntity category = new CategoryEntity();
        category.setCid(cid);
        return quizService.getQuizzesOfCategory(category);
    }
}
