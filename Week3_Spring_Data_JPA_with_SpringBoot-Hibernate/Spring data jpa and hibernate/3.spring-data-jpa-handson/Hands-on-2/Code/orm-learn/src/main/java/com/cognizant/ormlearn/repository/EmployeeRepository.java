package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Custom method to get all permanent employees
    @Query("SELECT e FROM Employee e WHERE e.permanent = true")
 List<Employee> findByPermanentTrue();

}
