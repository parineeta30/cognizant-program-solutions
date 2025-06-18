# FactoryMethodPatternExample

This project demonstrates the implementation of the "Factory Method Pattern" in Java.

## Exercise Objective:
  You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel). Use the Factory Method Pattern to achieve this.

## What�s Implemented:

### 1. `ConcreteClass` Interface
Defines a method `check()` which is implemented by all types of document classes.

### 2. Document Types:
- `WordDocument` � prints message for a Word file
- `PdfDocument` � prints message for a PDF file
- `ExcelDocument` � prints message for an Excel file

Each of these implements `ConcreteClass`.

### 3. Abstract Factory: 
- `DocumentFactory` � declares abstract method `createDocument()`.

### 4. Concrete Factories:
- `WordFactory`
- `PdfFactory`
- `ExcelFactory`

Each overrides `createDocument()` and returns the appropriate document object.

### 5. Test Class:
- `TestClass` creates instances using the respective factories and calls their `check()` methods to display messages.

---

## Output

This is a Word Document file...
This is a PDF document file...
This is an Excel document file...