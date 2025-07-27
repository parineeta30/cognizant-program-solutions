## Objectives
 
· Define Props
· Explain Default Props
· Identify the differences between State and Props
· Explain reactDOM.render()

1. Define Props
Props (short for properties) are read-only inputs to React components. They are used to pass data from a parent component to a child component. Props help components be reusable by allowing the parent to customize the child's behavior or appearance. Inside the child component, props can be accessed and used but cannot be modified.

-Eg:
If a Greeting component receives a name prop, it can display "Hello, {name}!" dynamically based on what the parent passes.

2. Explain Default Props
Default Props are the default values assigned to props if no value is passed from the parent component. This ensures that the component still has valid data to use and avoids errors due to undefined props. Default props can be defined by setting the defaultProps property on a component.

-Eg:
If a Button component expects a color prop, and none is provided, defining Button.defaultProps = { color: 'blue' } means the button will use blue color by default.


3. Identify the differences between State and Props
Aspect	                         Props	                                                   State
Origin	             Passed from parent component	                             Managed within the component itself
Mutability	         Read-only, cannot be changed by the child	                Mutable, can be updated by the component
Purpose	             To configure components and pass data	                    To store dynamic data that affects rendering
Usage	             Used to pass data and event handlers	                  Used to handle changes like user inputs, toggles
Lifecycle Impact	 Changes cause re-render if parent passes new props	     Changes trigger re-render via setState or hooks     
4. Explain reactDOM.render()
reactDOM.render() is a function provided by the ReactDOM library that renders a React component or elements into the actual DOM in the browser. It takes two arguments: the React element to render, and the DOM node (container) where the element should be inserted. This is usually called once in the app to mount the root React component.

-Eg:
js
ReactDOM.render(<App />, document.getElementById('root'));
This renders the App component inside the HTML element with id root.