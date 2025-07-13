package com.cognizant.springrest.controller;

import com.cognizant.springrest.model.Employee;
import com.cognizant.springrest.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("START getAllEmployees()");
        List<Employee> employeeList = employeeService.getAllEmployees();
        LOGGER.debug("Employee List: {}", employeeList);
        LOGGER.info("END getAllEmployees()");
        return employeeList;
    }
}
