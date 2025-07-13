# Hands-on 3: Entity and Table Setup for Payroll System :
This exercise sets up the foundational entity structure and database schema required to implement object-relational mappings using Spring Data JPA and Hibernate. The goal is to define entities representing a basic payroll system and map them correctly to a pre-defined database schema.

# Entities Involved:
Employee

Department

Skill

# Relationships to be Demonstrated:
One-to-Many (Department → Employees)

Many-to-One (Employee → Department)

Many-to-Many (Employee ↔ Skills)

# Steps Performed:
Database Schema Setup
A MySQL schema named payroll_db was used.

Tables were created using a payroll.sql script.

The schema contains:

employee

department

skill

employee_skill (join table for many-to-many)

Note: The actual SQL file (payroll.sql) was not provided in the platform. A placeholder setup or assumed schema based on the diagram was used.

## Entity Definitions:
Each entity was annotated with @Entity, and mapped to its respective table using @Table.

Employee

Fields: id, name, salary, permanent, dateOfBirth

Department

Fields: id, name

Skill

Fields: id, name

## Repositories:
Created Spring Data JPA interfaces for:

EmployeeRepository

DepartmentRepository

SkillRepository

## Configuration:
Connection to MySQL configured in application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/payroll_db
spring.datasource.username=root
spring.datasource.password=my-pswd

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
# Build and Run:
Successfully ran mvn clean install

Application started without errors using mvn spring-boot:run

JPA setup and database connectivity confirmed

## Testing:
No explicit testing was required in this hands-on.
The objective was purely schema creation and Hibernate entity mapping.

# Notes:
This setup forms the base for subsequent hands-on exercises that involve persistence operations and relationship handling.
While the original payroll.sql was not provided, all entities and mappings were implemented using the schema diagram reference.

