package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    private int id;

    @Column(name = "attempted_date")
    private LocalDate attemptedDate;

    @ManyToOne
    @JoinColumn(name = "at_us_id") // Must match schema.sql
    private User user;

  @OneToMany(mappedBy = "attempt", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
private Set<AttemptQuestion> attemptQuestions;


    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getAttemptedDate() {
        return attemptedDate;
    }

    public void setAttemptedDate(LocalDate attemptedDate) {
        this.attemptedDate = attemptedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<AttemptQuestion> getAttemptQuestions() {
        return attemptQuestions;
    }

    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions = attemptQuestions;
    }
}
