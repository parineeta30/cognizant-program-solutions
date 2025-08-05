# Objectives

- Explain about React forms
- Define controlled components
- Explain about various input controls
- Explain about handling forms
- Explain about submitting forms

---

## React Forms

React forms are components designed to collect and manage user inputs. Unlike standard HTML forms, React forms are typically controlled by the component state, making the data flow more predictable and easier to manage within a React application. This structure allows for real-time validation, dynamic feedback, and a more unified control of form data[21][22][23][24].

---

## Controlled Components

A controlled component in React is a form element (like `<input>`, `<textarea>`, or `<select>`) whose value is managed by React state, not the DOM. The current value is always driven by the component's state, and React controls all updates to it. This approach provides a single source of truth, easier validation, and the ability to manipulate form data more flexibly[22][26][31].

**Example:**
const [value, setValue] = useState("");
<input value={value} onChange={e => setValue(e.target.value)} />

---

## Various Input Controls

React supports several input controls, including:

- **Text Input:** `<input type="text" />`
- **Password Input:** `<input type="password" />`
- **Email Input:** `<input type="email" />`
- **Number Input:** `<input type="number" />`
- **Checkbox:** `<input type="checkbox" />`
- **Radio Button:** `<input type="radio" />`
- **Textarea:** `<textarea />`
- **Select Dropdown:** `<select><option>...</option></select>`

You use the `value`, `checked`, and `onChange` props to create controlled versions of each of these input types[23][32].

---

## Handling Forms

In React, handling forms means managing form data within the component state. You use `useState()` (or class `state`) to store form values and supply change handlers (`onChange`) to keep state in sync with user input. Best practices include handling changes for multiple input fields efficiently through a single `handleChange` function and updating the state immutably[21][23][28].

**Example:**
const [formData, setFormData] = useState({ name: "", email: "" });
const handleChange = e => {
setFormData({...formData, [e.target.name]: e.target.value});
};

---

## Submitting Forms

To submit a form in React, attach an `onSubmit` event handler to the `<form>` element. Typically, you call `event.preventDefault()` to prevent the page from reloading and then process the form data stored in the component state. After submission, you may display a message, reset the form, or trigger other actions[21][23][28].

**Example:**
const handleSubmit = event => {
event.preventDefault();
// process formData here
};

<form onSubmit={handleSubmit}>...</form> ```
React's approach to forms emphasizes state control, real-time validation, and user experience improvements over traditional HTML forms.