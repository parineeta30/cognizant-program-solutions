# Microservices with Eureka Discovery Server and Spring Cloud API Gateway

This project demonstrates basic microservices architecture using Spring Boot, Spring Cloud Eureka Discovery Server, and Spring Cloud Gateway.

---

##  Projects Included

1. **Eureka Discovery Server**
2. **Loan Service**
3. **Account Service**
4. **Hello Service** (Hello World Microservice)
5. **API Gateway**

---

##  Prerequisites

- Java 17+
- Maven 3.6+
- Spring Boot 3.3.x (Compatible with Spring Cloud 2023.0.x or 2025.0.x)
- Internet connection for downloading dependencies

---

##  How to Run

### 1. Start Eureka Discovery Server

```bash
cd eureka-discovery-server
mvn clean install
java -jar target/eureka-discovery-server-0.0.1-SNAPSHOT.jar
