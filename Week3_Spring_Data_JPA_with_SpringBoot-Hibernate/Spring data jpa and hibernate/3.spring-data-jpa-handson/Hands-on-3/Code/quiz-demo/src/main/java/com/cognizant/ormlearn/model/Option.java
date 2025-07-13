package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "options") // Explicitly map to correct table
public class Option {

    @Id
    private int id;

    private String text;

    @Column(name = "is_correct") // Explicit column name from schema
    private boolean isCorrect;

    private double score;

    @ManyToOne
    @JoinColumn(name = "question_id") // Foreign key in options table
    private Question question;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
