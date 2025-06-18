# SingletonPatternExample

##  Exercise 1: Implementing the Singleton Pattern

### Scenario
You need to ensure that a logging utility class in your application has only one instance throughout the application lifecycle to ensure consistent logging.

---

###  Steps Followed

1. Created a Java Project  
   Project Name:"SingletonPatternExample"

2. Defined a Singleton Class
   - Created a class named `Logger`
   - Made the constructor `private`
   - Used a `private static Logger instance` variable
   - Provided a "public static getLogger()"method to return the instance

3. Implemented the Singleton Pattern
   - Used **Double-Checked Locking** with `synchronized` block to ensure thread safety

4. Tested the Singleton Implementation
   - Created a class "TestClass"
   - Fetched the instance twice and printed their hash codes
   - Verified that both instances are the same

---

###  Sample Output

Logger1 hashCode: 1933863327
Logger2 hashCode: 1933863327
Same instance? true

