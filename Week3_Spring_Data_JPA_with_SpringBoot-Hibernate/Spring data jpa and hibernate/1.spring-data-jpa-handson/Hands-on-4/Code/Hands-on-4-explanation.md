
# Hands-on 4: Difference between JPA, Hibernate, and Spring Data JPA

## 🔹 Java Persistence API (JPA)
- A specification (JSR 338) for persisting, reading, and managing data from Java objects.
- JPA **does not provide an implementation** by itself.
- It defines interfaces and annotations (like `@Entity`, `@Id`, `@OneToMany`, etc.).
- Requires a provider like **Hibernate** for actual implementation.

## 🔹 Hibernate
- A **popular ORM (Object Relational Mapping)** tool.
- It is a **concrete implementation** of the JPA specification.
- Helps map Java classes to database tables.
- Requires explicit code to manage session, transaction, and save operations.

###  Example: Hibernate Code to Add an Employee
```java
/* Method to CREATE an employee in the database */
public Integer addEmployee(Employee employee){
   Session session = factory.openSession();
   Transaction tx = null;
   Integer employeeID = null;

   try {
      tx = session.beginTransaction();
      employeeID = (Integer) session.save(employee); 
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
   return employeeID;
}
```

## 🔹 Spring Data JPA
- A **higher abstraction layer** over JPA and its providers like Hibernate.
- Helps eliminate boilerplate code (no need to manage session or transaction manually).
- Comes with built-in repository interfaces (like `JpaRepository`).
- Automatically handles common DB operations like save, delete, find, etc.
- Integrated with Spring Boot for auto-configuration.

### Example: Spring Data JPA Code

**EmployeeRepository.java**
```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

**EmployeeService.java**
```java
@Autowire
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

