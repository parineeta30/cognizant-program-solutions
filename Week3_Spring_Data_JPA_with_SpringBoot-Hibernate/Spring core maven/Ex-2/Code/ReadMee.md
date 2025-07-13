# Exercise 2 - Implementing Dependency Injection

This exercise demonstrates the use of Spring's IoC container and setter-based Dependency Injection.

## Technologies Used :
- Java
- Maven
- Spring Core (v5.3.30)

##  Objective :
Manage dependencies between `BookService` and `BookRepository` using Spring's Dependency Injection (DI).

## Steps Performed :
- Updated `applicationContext.xml` to inject `BookRepository` into `BookService`.
- Added a setter method in `BookService` for DI.
- Verified the DI by running the main class.

## How to Run :
mvn clean compile
mvn exec:java 
