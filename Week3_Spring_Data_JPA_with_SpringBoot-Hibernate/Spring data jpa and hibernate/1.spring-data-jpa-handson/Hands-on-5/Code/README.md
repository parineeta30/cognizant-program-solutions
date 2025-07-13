# Country Management REST API (Spring Boot + Spring Data JPA)

This project implements a RESTful API for managing countries using Spring Boot and Spring Data JPA.

## Features Implemented :

- Find a country based on country code
- Add a new country
- Update an existing country
- Delete a country
- and a list of countries matching a partial country name

---


##  Configuration:

**application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=root
spring.datasource.password=30_parineeta
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

##  API Endpoints:

| Method | Endpoint                        | Description                          |
|--------|----------------------------------|--------------------------------------|
| GET    | `/countries/{code}`             | Get country by code                  |
| POST   | `/countries`                    | Add new country                      |
| PUT    | `/countries/{code}`             | Update existing country              |
| DELETE | `/countries/{code}`             | Delete country by code               |
| GET    | `/countries/search?name=xxx`    | Search countries by partial name     |


---

##  Sample JSON for POST:

```json
{
  "code": "IN",
  "name": "India"
}
```

---

## How to Run:

1. Create the database schema in MySQL.
2. Run the insert script to populate `country` table.
3. Build and run the Spring Boot app using:
```bash
mvn spring-boot:run
```
4. Test done using Postman

---

##  Sample SQL Insert:

```sql
INSERT INTO country (co_code, co_name) VALUES ('AF', 'Afghanistan'), ('AL', 'Albania'), ('DZ', 'Algeria');
-- Add more countries as needed
```

---
