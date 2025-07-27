# Objectives
 
·Explain React State:

React State is a special built-in object used to store dynamic data within a React component. Unlike props, which are passed from parent to child, state is managed locally by the component itself.

Purpose: State holds information that can change over time (such as user input, whether something is shown/hidden, counters, etc.) and directly affects how a component appears or behaves.

Mutability: Unlike props, state is mutable—it can be updated by the component using special methods (setState in class components, or the state updater function in hooks for function components).

Reactivity: When state changes, React automatically re-renders the component, updating the UI to show the latest state values.

Usage: In class components, state is typically initialized in the constructor:

js
this.state = { counter: 0 };
And updated with:

js
this.setState({ counter: this.state.counter + 1 });
In function components, state is managed using the useState hook:

js
const [counter, setCounter] = useState(0);
setCounter(counter + 1);









