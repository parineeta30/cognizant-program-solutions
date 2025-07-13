package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.repository.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptServiceImpl implements AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    @Override
    public Attempt getAttemptById(int id) {
        return attemptRepository.findById(id).orElse(null);
    }

    @Override
    public Attempt getAttempt(int userId, int attemptId) {
        System.out.println("Fetching Attempt for userId=" + userId + ", attemptId=" + attemptId);

        return attemptRepository.getAttempt(userId, attemptId);
    }
}
