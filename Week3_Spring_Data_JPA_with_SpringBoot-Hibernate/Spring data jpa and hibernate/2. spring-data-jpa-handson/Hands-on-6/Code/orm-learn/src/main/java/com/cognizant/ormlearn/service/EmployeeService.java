package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;

public interface EmployeeService {
    Employee get(int id);
    void save(Employee employee);
}