# Hands-on 6: Spring Data JPA - Many-to-Many Relationship (Employee & Skill)

This Spring Boot project demonstrates how to implement a **many-to-many relationship** between `Employee` and `Skill` entities using **Spring Data JPA** and **Hibernate**.

---

## Relationship Overview

- Each `Employee` can have **multiple Skills**
- Each `Skill` can belong to **multiple Employees**
- Mapped via a join table: `employee_skill`

---

## Features

- Define a `ManyToMany` relationship using `@JoinTable`
- Use `FetchType.EAGER` to avoid `LazyInitializationException`
- Retrieve employee data along with associated skills
- Add new skill associations to employees via service logic
- Verify mappings via logs and database join table

---

## Configuration

Make sure to update the `application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/payroll_db
spring.datasource.username=root
spring.datasource.password=my_pswd
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
logging.level.com.cognizant.ormlearn=DEBUG
