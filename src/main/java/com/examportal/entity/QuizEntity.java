package com.examportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "QUIZ")
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qid;

    private String title;

    @Column(length = 5000)
    private String description;

    private String maxMarks;

    private String noOfQuestions;

    private Boolean active = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<QuestionEntity> questions = new HashSet<>();

    public QuizEntity() {
    }

    public QuizEntity(Long qid, String title, String description, String maxMarks, String noOfQuestions, Boolean active, CategoryEntity category, Set<QuestionEntity> questions) {
        this.qid = qid;
        this.title = title;
        this.description = description;
        this.maxMarks = maxMarks;
        this.noOfQuestions = noOfQuestions;
        this.active = active;
        this.category = category;
        this.questions = questions;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(String noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Set<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionEntity> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        QuizEntity that = (QuizEntity) o;
        return Objects.equals(qid, that.qid) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(maxMarks, that.maxMarks) && Objects.equals(noOfQuestions, that.noOfQuestions) && Objects.equals(active, that.active) && Objects.equals(category, that.category) && Objects.equals(questions, that.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qid, title, description, maxMarks, noOfQuestions, active, category, questions);
    }

    @Override
    public String toString() {
        return "QuizEntity{" +
                "qid=" + qid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", maxMarks='" + maxMarks + '\'' +
                ", noOfQuestions='" + noOfQuestions + '\'' +
                ", active=" + active +
                ", category=" + category +
                ", questions=" + questions +
                '}';
    }
}
