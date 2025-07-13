# Exercise 6: Configuring Beans with Annotations : 
This exercise demonstrates how to simplify Spring bean configuration using annotations instead of XML definitions.

 ##  What was done :
Enabled component scanning in applicationContext.xml.

Annotated BookService with @Service.

Annotated BookRepository with @Repository.

Used @Autowired for automatic dependency injection.

# How to Run:
mvn clean test
mvn exec:java

## Output :

Adding book: Spring Annotations
Saving book: Spring Annotations
