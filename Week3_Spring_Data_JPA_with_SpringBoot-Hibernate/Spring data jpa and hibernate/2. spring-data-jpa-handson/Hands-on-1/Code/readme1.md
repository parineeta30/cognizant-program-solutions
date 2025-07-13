# Hands-on 1: Query Methods on Country Table

##  Objective
Implement and test Spring Data JPA **query methods** on the `country` table to support search functionality commonly used in applications.

---

##
---

## MySQL Table Setup

```sql
CREATE DATABASE country_db;

USE country_db;

CREATE TABLE country (
    co_code VARCHAR(5) PRIMARY KEY,
    co_name VARCHAR(255) NOT NULL
);

-- Sample data
INSERT INTO country (co_code, co_name) VALUES 
('ZA', 'South Africa'),
('NP', 'Nepal'),
('DJ', 'Djibouti'),
('LU', 'Luxembourg'),
('ZM', 'Zambia'),
('ZW', 'Zimbabwe'),
('TF', 'French Southern Territories'),
('GP', 'Guadeloupe'),
('GS', 'South Georgia and the South Sandwich Islands'),
('UM', 'United States Minor Outlying Islands'),
('SS', 'South Sudan'),
('BV', 'Bouvet Island');

```

## Query Methods Implemented in CountryRepository

// Get countries containing keyword (e.g., "ou")
List<Country> findByNameContaining(String keyword);

// Get countries containing keyword and sorted ascending
List<Country> findByNameContainingOrderByNameAsc(String keyword);

// Get countries starting with a specific alphabet
List<Country> findByNameStartingWith(String prefix);

## Outcome
Successfully implemented query methods using Spring Data JPA.

Verified functionality to:

Search countries by keyword.

Retrieve sorted results.

Filter by starting alphabet.


