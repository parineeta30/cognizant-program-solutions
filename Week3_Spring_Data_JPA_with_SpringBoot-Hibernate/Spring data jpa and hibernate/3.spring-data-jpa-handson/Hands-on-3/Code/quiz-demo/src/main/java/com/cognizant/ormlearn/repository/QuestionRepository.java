package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // You can add custom queries if needed in the future
}
