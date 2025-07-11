package com.examportal.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "QUESTIONS")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quesId;

    @Column(length = 5000)
    private String content;

    private String image;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String answer;

    @Transient
    private String givenAnswer;

    @ManyToOne(fetch = FetchType.EAGER)
    private QuizEntity quiz;

    public QuestionEntity() {
    }

    public QuestionEntity(Long quesId, String content, String image, String option1, String option2, String option3, String option4, String answer, QuizEntity quiz) {
        this.quesId = quesId;
        this.content = content;
        this.image = image;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.quiz = quiz;
    }

    public Long getQuesId() {
        return quesId;
    }

    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public QuizEntity getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizEntity quiz) {
        this.quiz = quiz;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuestionEntity that = (QuestionEntity) o;
        return Objects.equals(quesId, that.quesId) && Objects.equals(content, that.content) && Objects.equals(image, that.image) && Objects.equals(option1, that.option1) && Objects.equals(option2, that.option2) && Objects.equals(option3, that.option3) && Objects.equals(option4, that.option4) && Objects.equals(answer, that.answer) && Objects.equals(givenAnswer, that.givenAnswer) && Objects.equals(quiz, that.quiz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quesId, content, image, option1, option2, option3, option4, answer, givenAnswer, quiz);
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "quesId=" + quesId +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", answer='" + answer + '\'' +
                ", givenAnswer='" + givenAnswer + '\'' +
                ", quiz=" + quiz +
                '}';
    }
}
