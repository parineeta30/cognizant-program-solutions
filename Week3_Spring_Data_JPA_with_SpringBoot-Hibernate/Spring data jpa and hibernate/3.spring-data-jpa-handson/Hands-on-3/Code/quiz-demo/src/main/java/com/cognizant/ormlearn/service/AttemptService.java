package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Attempt;

public interface AttemptService {
    Attempt getAttemptById(int id);
    Attempt getAttempt(int userId, int attemptId);
}
