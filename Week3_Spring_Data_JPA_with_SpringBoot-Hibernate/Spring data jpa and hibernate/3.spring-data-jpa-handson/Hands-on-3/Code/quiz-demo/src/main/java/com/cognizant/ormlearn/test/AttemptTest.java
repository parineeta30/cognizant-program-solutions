package com.cognizant.ormlearn.test;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AttemptTest implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    @Override
    public void run(String... args) throws Exception {
        testGetAttempt();
    }

    private void testGetAttempt() {
        int userId = 1;        // from data.sql
        int attemptId = 100;   // from data.sql

        Attempt attempt = attemptService.getAttempt(userId, attemptId);

        if (attempt == null) {
            System.out.println("Attempt not found");
            return;
        }

        System.out.println("Username: " + attempt.getUser().getName());
        System.out.println("Attempted Date: " + attempt.getAttemptedDate());

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            Question question = aq.getQuestion();
            System.out.println("\nQuestion: " + question.getText());

            for (Option option : question.getOptions()) {
                boolean selected = aq.getAttemptOptions().stream()
                        .anyMatch(ao -> ao.getOption().getId() == option.getId());

                String formatted = String.format("%d) %-15s %.1f\t%s",
                        option.getId(),
                        option.getText(),
                        option.getScore(),
                        selected ? "true" : "false");

                System.out.println(formatted);
            }
        }
    }
}
