package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.DepartmentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);

        testAddEmployee();
        testGetEmployee();
        testUpdateEmployee();
    }

    private static void testAddEmployee() throws Exception {
        LOGGER.info("Start testAddEmployee");

        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setSalary(50000);
        emp.setPermanent(true);
        emp.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-20"));

        Department dept = departmentService.get(1);
        emp.setDepartment(dept);

        employeeService.save(emp);
        LOGGER.debug("Saved Employee: {}", emp);

        LOGGER.info("End testAddEmployee");
    }

    private static void testGetEmployee() {
        LOGGER.info("Start testGetEmployee");

        Employee emp = employeeService.get(1);
        LOGGER.debug("Employee: {}", emp);
        LOGGER.debug("Department: {}", emp.getDepartment());

        LOGGER.info("End testGetEmployee");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start testUpdateEmployee");

        Employee emp = employeeService.get(1);
        Department newDept = departmentService.get(2);
        emp.setDepartment(newDept);
        employeeService.save(emp);

        LOGGER.debug("Updated Employee: {}", emp);
        LOGGER.info("End testUpdateEmployee");
    }
}
