## Objectives

- Explain React events : 
React events are actions or occurrences, such as user interactions (click, input, submit, mouse movement) or browser actions, that a React component can respond to. React wraps these browser events to provide consistent behavior across different browsers. Common examples include onClick, onChange, onSubmit, etc., allowing React apps to interact with users and respond to UI actions.

Example:

jsx
<button onClick={handleClick}>Click Me</button>
Here, the onClick event allows the developer to handle button clicks using the handleClick function.

- Explain about event handlers
Event handlers are the functions you define that get executed when a specific event occurs. In React, event handlers are typically defined as methods (in class components) or as functions (in function components). They are passed to component props like onClick, onChange, and are called in response to events.

Example:

jsx
function handleClick() {
  alert('The button was clicked!');
}
// ...
<button onClick={handleClick}>Click Me</button>
Here, handleClick is the event handler for the click event.

- Define Synthetic event
A Synthetic event is React's cross-browser wrapper around the browser’s native event. It wraps the browser’s event system, normalizing events so that they have consistent properties across all browsers. When you use onClick, onChange, etc., in React, you are working with a SyntheticEvent instance, not the raw DOM event, making code more portable.

Example:

jsx
function handleInput(event) {
  console.log(event.target.value); // 'event' is a SyntheticEvent
}
<input onChange={handleInput} />
Here, event is a SyntheticEvent, which mimics the properties of the DOM event.

- Identify React event naming convention
React follows a camelCase naming convention for event handler props—unlike HTML, which uses all lowercase. For example, React uses onClick (not onclick), onChange (not onchange), and so on. Handler functions themselves are often named with a "handle" prefix (like handleClick, handleSubmit) and passed to these event attributes.

Example:

jsx
<button onMouseOver={handleMouseOver}>Hover Me</button>
<input onChange={handleChange} />
