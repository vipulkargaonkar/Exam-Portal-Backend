package com.examportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;

    private String title;

    @Column(length = 5000)
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<QuizEntity> quizzes = new LinkedHashSet<>();

    public CategoryEntity() {
    }

    public CategoryEntity(Long cid, String title, String description, Set<QuizEntity> quizzes) {
        this.cid = cid;
        this.title = title;
        this.description = description;
        this.quizzes = quizzes;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public Set<QuizEntity> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<QuizEntity> quizzes) {
        this.quizzes = quizzes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(cid, that.cid) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(quizzes, that.quizzes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, title, description, quizzes);
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "cid=" + cid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", quizzes=" + quizzes +
                '}';
    }
}
