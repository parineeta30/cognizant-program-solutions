# ES6 Features and Fundamentals

## Objectives

- List the features of ES6
- Explain JavaScript `let`
- Identify the differences between `var` and `let`
- Explain JavaScript `const`
- Explain ES6 class fundamentals
- Explain ES6 class inheritance
- Define ES6 arrow functions
- Identify `set()` and `map()`

---

## Features of ES6

- **let and const Keywords:** Block-scoped variable declarations, improving safety and predictability.
- **Arrow Functions:** Shorter syntax for writing functions, with lexical `this`.
- **Classes:** Cleaner, object-oriented syntax for creating objects and managing inheritance.
- **Template Literals:** Enhanced string handling with embedded expressions.
- **Destructuring Assignment:** Easy extraction of values from arrays and objects.
- **Spread and Rest Operators:** Simplifies handling of arrays and function arguments.
- **Promises:** Simplifies asynchronous code and error handling.
- **Default Parameters:** Allows default values in function parameters.
- **Modules:** Organize and reuse code using `import` and `export`.

---

## JavaScript `let`

The `let` keyword is used to declare a block-scoped variable, optionally initializing it to a value. Unlike `var`, variables declared with `let` are only available within the nearest enclosing block and cannot be redeclared in the same scope. They are hoisted but not initialized (causing a ReferenceError if accessed before declaration)—this is called the Temporal Dead Zone.

---

## Differences Between `var` and `let`

| Feature        | var                                | let                                  |
|----------------|-----------------------------------|-------------------------------------|
| **Scope**      | Function/global scoped             | Block scoped                        |
| **Hoisting**   | Yes, initialized as `undefined`    | Yes, but uninitialized (TDZ)         |
| **Redeclaration** | Allowed in the same scope         | Not allowed in same scope            |
| **Use**        | Accessible throughout function     | Only within block it was defined     |

Variables declared with `let` are safer and less prone to bugs caused by variable hoisting or redeclaration.

---

## JavaScript `const`

The `const` keyword is for block-scoped, read-only variables. A `const` variable:

- Must be initialized at the time of declaration.
- Cannot be reassigned after initialization.
- Retains block scope like `let`.

> **Note:** If you assign an object or array to a `const`, the reference is fixed, but the contents can still be modified.

---

## ES6 Class Fundamentals

- Classes use the `class` keyword for defining templates for objects.
- They include a constructor method and can define instance methods directly inside the class body.
- Classes help organize code and mimic classical OOP structure in JavaScript.

**Example:**
class Person {
constructor(name) {
this.name = name;
}
greet() {
return Hello, ${this.name};
}
}


---

## ES6 Class Inheritance

- Use the `extends` keyword for inheritance.
- The child class inherits methods/properties of the parent.
- The `super()` function in the child constructor calls the parent’s constructor, enabling access to parent properties/methods.

**Example:**
class Animal {
constructor(species) {
this.species = species;
}
}
class Dog extends Animal {
constructor(name) {
super('Dog');
this.name = name;
}
}


---

## ES6 Arrow Functions

- Shorter syntax: `const fn = (a, b) => a + b;`
- Do not have their own `this` or `arguments`, they inherit from the outer scope.
- Not suited for object methods, but great for callbacks and short functions.

---

## Identifying `set()` and `map()`

### Set

- `Set` holds **unique values only**, removing duplicates automatically.
- Values can be of any type (primitives, objects).
- Methods: `add()`, `delete()`, `has()`, `clear()`, and others.
let s = new Set([1, //Set {1, 2, 3}])


### Map

- `Map` stores key-value pairs.
- Keys can be any type (unlike objects, where keys are always strings).
- Maintains the insertion order of keys.

let m = new Map();
m.set('a', 1);
m.set('b', 2);

