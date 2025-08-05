# Objectives:

- Define JSX
JSX (JavaScript XML) is a syntax extension for JavaScript popularized by React. It allows you to write HTML-like code inside JavaScript files. JSX makes it easier to describe the UI structure in a way that closely resembles the final output, providing better readability and error checking during development.

Example :
const element = <h1>Hello, World!</h1>;

- Explain about ECMA Script
ECMAScript (often abbreviated as ES) is the standardized scripting language specification on which JavaScript is based. Updates are released as versions (like ES5, ES6/ES2015, ES7, etc.). Modern JavaScript—including features like arrow functions, let/const declarations, classes, and modules—originated in ECMAScript releases, especially ES6 (2015). When working with React, ES6+ features are commonly used for writing clean, efficient, and modular code.

- Explain React.createElement()
React.createElement() is a core method in the React library that creates a React element representation for rendering in the DOM. JSX syntax is syntactic sugar for calls to React.createElement().

Example :
const element = <h1>Hello</h1>;
// is transformed to:
const element = React.createElement('h1', null, 'Hello');

- Explain how to create React nodes with JSX
You can create React nodes (elements or components) using JSX by writing HTML-like code within your JavaScript files. Each JSX tag creates a React element in memory.

Example :
const title = <h2>Welcome</h2>;
const button = <button>Click Me</button>;

JSX tags may be single elements or custom components:

function Welcome(props) {
  return <h3>Hello, {props.name}</h3>;
}
const greeting = <Welcome name="Alice" />;

- Define how to render JSX to DOM
Rendering JSX to the DOM means taking JSX code and displaying it in the browser. In React, you use the ReactDOM.render() (or root.render() in React 18+) method to mount a root component (often containing JSX) onto a DOM node.

Example:
import React from 'react';
import ReactDOM from 'react-dom/client';

const element = <h1>Hello, world!</h1>;
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(element);


- Explain how to use JavaScript expressions in JSX
JavaScript expressions can be embedded inside JSX using curly braces {}. This enables dynamic content, variable interpolation, function calls, and logic.

Example:
const user = 'Nina';
const element = <p>Hello, {user}!</p>;
// Output: <p>Hello, Nina!</p>

const sum = (a, b) => a + b;
const result = <span>{sum(2, 3)}</span>;
// Output: <span>5</span>

- Explain how to use inline CSS in JSX
To apply inline styles in JSX, you use a JavaScript object with camelCase property names instead of a CSS string. The style attribute in JSX takes an object, not a string.
JSX requires camelCase (e.g., backgroundColor not background-color) and values must be strings or numbers.

Example:
const styleObj = {
  color: 'blue',
  fontSize: '20px',
  backgroundColor: '#eee'
};

const element = <h2 style={styleObj}>Styled Heading</h2>;

Or inline directly
<h2 style={{ color:'red', margin:'12px' }}>Important Notice</h2>
