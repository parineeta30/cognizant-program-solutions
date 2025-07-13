package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.service.AttemptService;

import com.cognizant.ormlearn.model.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizAttemptHqlDemoApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(QuizAttemptHqlDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        getAttemptDetails(1, 100); // example userId=1, attemptId=1
    }

    private void getAttemptDetails(int userId, int attemptId) {
        Attempt attempt = attemptService.getAttempt(userId, attemptId);
        if (attempt == null) {
            System.out.println("No attempt found.");
            return;
        }

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            Question q = aq.getQuestion();
            System.out.println(q.getText());
            for (Option option : q.getOptions()) {
                double score = option.getScore();
                boolean selected = aq.getAttemptOptions().stream()
                    .anyMatch(ao -> ao.getOption().getId() == option.getId());
                System.out.printf(" %d) %s\t%.1f\t%s\n",
                        option.getId(),
                        option.getText(),
                        score,
                        selected ? "true" : "false");
            }
            System.out.println();
        }
    }
}
