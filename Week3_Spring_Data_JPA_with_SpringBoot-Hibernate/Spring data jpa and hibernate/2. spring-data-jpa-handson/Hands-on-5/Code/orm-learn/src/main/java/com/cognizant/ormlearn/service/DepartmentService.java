package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department get(int id) {
        LOGGER.info("Start get department with id {}", id);
        Optional<Department> result = departmentRepository.findById(id);
        if (result.isPresent()) {
            LOGGER.info("Department found: {}", result.get());
            return result.get();
        } else {
            LOGGER.warn("Department with id {} not found", id);
            return null; // or throw custom exception
        }
    }

    @Transactional
    public void save(Department department) {
        LOGGER.info("Saving department: {}", department);
        departmentRepository.save(department);
        LOGGER.info("Department saved");
    }
}
