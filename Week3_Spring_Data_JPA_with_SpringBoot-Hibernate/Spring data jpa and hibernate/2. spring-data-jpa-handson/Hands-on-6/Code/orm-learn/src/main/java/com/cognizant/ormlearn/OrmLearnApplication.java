package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // testGetEmployee();
        testAddSkillToEmployee();
    }

    private void testGetEmployee() {
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee.getName());
        LOGGER.debug("Department: {}", employee.getDepartment().getName());
        LOGGER.debug("Skills: {}", employee.getSkillList());
    }

    private void testAddSkillToEmployee() {
        Employee employee = employeeService.get(1);
        Skill newSkill = skillService.get(6);

        if (!employee.getSkillList().contains(newSkill)) {
            employee.getSkillList().add(newSkill);
            employeeService.save(employee);
            LOGGER.debug("Skill added to employee.");
        } else {
            LOGGER.debug("Skill already present.");
        }
    }
}