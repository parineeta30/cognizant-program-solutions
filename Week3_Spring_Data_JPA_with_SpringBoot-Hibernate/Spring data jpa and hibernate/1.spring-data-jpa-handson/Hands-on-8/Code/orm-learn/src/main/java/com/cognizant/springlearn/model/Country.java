package com.cognizant.springlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code", length = 5)
    private String code;

    @Column(name = "co_name", nullable = false)
    private String name;

    public Country() {
        // Default constructor required by JPA
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Optional: for better debug output
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}