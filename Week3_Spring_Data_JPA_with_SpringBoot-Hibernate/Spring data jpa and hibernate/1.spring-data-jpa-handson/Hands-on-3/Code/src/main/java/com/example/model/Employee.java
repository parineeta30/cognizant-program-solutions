package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private int salary;

    // ✅ Required getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {  // <-- this was missing
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {  // <-- this was missing
        this.salary = salary;
    }

    // Optional: toString
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}
