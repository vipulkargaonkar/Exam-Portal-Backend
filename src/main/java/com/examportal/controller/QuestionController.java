package com.examportal.controller;

import com.examportal.entity.QuestionEntity;
import com.examportal.entity.QuizEntity;
import com.examportal.service.QuestionService;
import com.examportal.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    private final QuestionService questionService;

    private final QuizService quizService;

    public QuestionController(QuestionService questionService, QuizService quizService) {
        this.questionService = questionService;
        this.quizService = quizService;
    }

    @PostMapping("/")
    public ResponseEntity<QuestionEntity> addQuestion(@RequestBody QuestionEntity question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<QuestionEntity> updateQuestion(@RequestBody QuestionEntity question) {
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid) {
        QuizEntity quiz = quizService.getQuiz(qid);
        Set<QuestionEntity> questions = questionService.getQuestionsOfQuiz(quiz);
        List<QuestionEntity> list = new ArrayList<>(questions);
        if (!list.isEmpty())
            list = list.subList(0, questions.size());
        list.forEach((ques) -> {
            ques.setAnswer("");
        });
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") Long qid) {
        QuizEntity quiz = new QuizEntity();
        quiz.setQid(qid);
        Set<QuestionEntity> questions = questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{quesId}")
    public QuestionEntity get(@PathVariable("quesId") Long quesId) {
        return questionService.getQuestion(quesId);
    }

    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable("quesId") Long quesId) {
        questionService.deleteQuestion(quesId);
    }

    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<QuestionEntity> questions) {
        double marksGot = 0;
        int correctAnswer = 0;
        int attempted = 0;
        for (QuestionEntity q : questions) {
            QuestionEntity question = questionService.get(q.getQuesId());
            if (question.getAnswer().equals(q.getGivenAnswer())) {
                correctAnswer++;
                double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
                marksGot += marksSingle;
            }

            if (q.getGivenAnswer() != null) {
                attempted++;
            }
        }
        Map<String, Object> map = Map.of("marksGot", marksGot, "correctAnswers", correctAnswer, "attempted", attempted);
        return ResponseEntity.ok(map);
    }
}
