package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static DepartmentService departmentService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        departmentService = context.getBean(DepartmentService.class);
        testGetDepartment();
    }

    private static void testGetDepartment() {
        LOGGER.info("START: testGetDepartment()");
        try {
            Department department = departmentService.get(1);
            if (department != null) {
                LOGGER.debug("Department: {}", department);
                LOGGER.debug("Employees: {}", department.getEmployeeList());
            } else {
                LOGGER.warn("No department found with the given ID");
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while fetching department: ", e);
        }
        LOGGER.info("END: testGetDepartment()");
    }
}
