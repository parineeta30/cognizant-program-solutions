

## 1. What are React Components?
React components are like building blocks of a web page. They help us divide the user interface (UI) into small, reusable parts. For example, we can have a Header component, a Footer component, and a Home component – all working together.

## 2. Difference Between React Components and JavaScript Functions

| React Component             | JavaScript Function                    |
|----------------------------|----------------------------------------|
| Returns JSX (HTML + JS)    | Returns data or values                 |
| Used to build UI           | Used for logic or calculations         |
| Can have state and props   | Doesn't have state or props by default |
| Has lifecycle methods      | No lifecycle methods                   |

## 3. Types of React Components
There are mainly two types of components in React:
- **Function Components** – Easy and commonly used.
- **Class Components** – Used before Hooks, more complex.

## 4. What is a Class Component?
Class components are a type of component written using ES6 classes. They can use state and lifecycle methods. Example:

```jsx
import React, { Component } from 'react';

class Welcome extends Component {
  render() {
    return <h1>Hello from Class Component!</h1>;
  }
}
```

## 5. What is a Function Component?
Function components are written as simple JavaScript functions. They're easier and faster. Example:

```jsx
function Hello() {
  return <h1>Hello from Function Component!</h1>;
}
```

## 6. What is a Constructor in a Component?
In class components, the constructor is the place where we define initial values like state. It runs when the component is created.

```jsx
constructor(props) {
  super(props);
  this.state = { message: 'Hello' };
}
```

## 7. What is the render() Function?
The `render()` function is used inside class components. It tells React what to show on the screen. It must return JSX.

```jsx
render() {
  return <h2>Welcome to my app</h2>;
}
```

---
