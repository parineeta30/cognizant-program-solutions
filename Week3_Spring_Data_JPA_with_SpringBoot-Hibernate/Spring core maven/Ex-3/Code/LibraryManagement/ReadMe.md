# Exercise 3 - Implementing Logging with Spring AOP

This exercise demonstrates how to use Spring AOP to log method execution times.

## Technologies Used :
- Java
- Maven
- Spring Core
- Spring AOP

##  Objective :
Log the execution time of methods in `BookService` using Spring AOP.

## Steps Performed :
- Added Spring AOP dependency in `pom.xml`.
- Created `LoggingAspect` with `@Around` advice.
- Enabled AspectJ support and registered the aspect in `applicationContext.xml`.
- Verified logging by running the main class.

## How to Run : 

mvn clean compile
mvn exec:java 
