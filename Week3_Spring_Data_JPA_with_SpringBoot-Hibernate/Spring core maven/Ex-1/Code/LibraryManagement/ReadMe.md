# Exercise 1 - Configuring a Basic Spring Application

This exercise demonstrates the configuration of a simple Spring Core application using XML.

## 🛠 Technologies Used
- Java
- Maven
- Spring Core (v5.3.30)

## 🚀 Steps Performed
- Created a Maven project `LibraryManagement`
- Added Spring Core dependency in `pom.xml`
- Defined two beans: `BookService` and `BookRepository` in `applicationContext.xml`

## How to Run :
mvn clean compile
mvn exec:java -Dexec.mainClass="com.library.MainApp"

# Output :
Adding book: Introduction to Spring
Saving book: Introduction to Spring

