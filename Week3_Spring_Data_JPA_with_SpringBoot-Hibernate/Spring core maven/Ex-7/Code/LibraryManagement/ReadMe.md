# Exercise 7: Implementing Constructor and Setter Injection :

This exercise demonstrates how to use both constructor and setter injection in a Spring application using XML configuration.

##  What was done:
BookService class was modified to accept a String via constructor and a BookRepository via setter method.

applicationContext.xml was updated to:

Inject a string value using <constructor-arg>.

Inject a BookRepository bean using <property> (setter injection).

Verified the configuration by running the main application.

#  How to Run :
mvn clean test
mvn exec:java

# Output :
Constructor Injected category: Technology
Adding book in category [Technology]: Effective Java
Saving book: Effective Java



