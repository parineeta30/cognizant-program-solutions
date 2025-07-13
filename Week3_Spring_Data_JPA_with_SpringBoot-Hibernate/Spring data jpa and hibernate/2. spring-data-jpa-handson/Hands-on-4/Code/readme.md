# Spring Data JPA - Hands-on 4

This project demonstrates the implementation of a `Many-To-One` relationship between `Employee` and `Department` entities using Spring Data JPA.

---

##  Technologies Used

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- MySQL
- Hibernate
- Maven

---

---

##  Relationships

- Each `Employee` belongs to **one** `Department`.
- One `Department` can have **many** `Employees`.

---

##  Features Implemented

1. `@ManyToOne` mapping from `Employee` → `Department`
2. Auto-generated `em_dp_id` as foreign key in `employee` table
3. Service layer with `@Transactional` CRUD methods
4. Logging using SLF4J
5. Sample test methods:
   - `testAddEmployee()` – Add new employee
   - `testGetEmployee()` – Fetch employee with department
   - `testUpdateEmployee()` – Change an employee's department

---

 **Note**: Since no official data file was provided in the exercise, the sample data was created to test the application and verify persistence operations.


