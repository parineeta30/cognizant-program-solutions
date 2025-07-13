package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "aq_am_id") // Maps to FK in attempt_question table
    private Attempt attempt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aq_qt_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AttemptOption> attemptOptions;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Attempt getAttempt() {
        return attempt;
    }

    public void setAttempt(Attempt attempt) {
        this.attempt = attempt;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Set<AttemptOption> getAttemptOptions() {
        return attemptOptions;
    }

    public void setAttemptOptions(Set<AttemptOption> attemptOptions) {
        this.attemptOptions = attemptOptions;
    }
}
