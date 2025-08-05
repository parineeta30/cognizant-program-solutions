# Objectives

- Explain React Forms validation
- Identify the differences between React Form and HTML Form
- Explain about controlled components
- Identify various React Form input controls
- Explain how to handle React Forms
- Explain about submitting forms in React

---

## React Forms Validation

Form validation in React ensures user-provided data meets certain criteria before submission. You can implement validation by:
- Using **required** and other HTML attributes for basic validation.
- Adding custom validation logic that checks value formats (e.g., correct email, length).
- Leveraging libraries like **React Hook Form**, **Formik**, or **Yup** for more advanced or scalable validation features.

Common validation rules include required fields, pattern matching, minimum/maximum lengths, and custom validators. Libraries help manage error messages, real-time feedback, and form data handling efficiently.

---

## Differences Between React Form and HTML Form

| Feature           | HTML Form                                    | React Form                                  |
|-------------------|----------------------------------------------|---------------------------------------------|
| Data Management   | DOM manages input values                     | Component state manages input values        |
| Validation        | Built-in (via input attributes) or JS events | In-state or via libraries, fully customizable|
| Feedback          | Limited, hard to update dynamically          | Real-time, easy to display error messages   |
| Submission        | Page reloads by default                      | Typically AJAX, prevents reload             |
| Control Type      | Uncontrolled (usually)                       | Controlled (state-driven)                   |

---

## Controlled Components

A **controlled component** in React is an input element whose value is controlled by React state. On every change, a React event handler updates the state, and in turn, the input’s value reflects state changes. This guarantees that the displayed value is always in sync with the state, making it reliable for validation and advanced features[22][26][28][31].

**Example:**
const [value, setValue] = useState("");
<input value={value} onChange={e => setValue(e.target.value)} />


## React Form Input Controls

React supports the following main input controls:
- **Text Input:** `<input type="text" />`
- **Password Input:** `<input type="password" />`
- **Email Input:** `<input type="email" />`
- **Number Input:** `<input type="number" />`
- **Checkbox:** `<input type="checkbox" />`
- **Radio Button:** `<input type="radio" />`
- **Textarea:** `<textarea />`
- **Select Dropdown:** `<select><option>...</option></select>`



---

## Handling React Forms

Handling forms in React involves:
- Using **state** to store and update input values with hooks like `useState()`.
- Controlling input values via the `value` prop.
- Using `onChange` handlers to sync user input with state.
- Managing multiple inputs by combining their values into a single state object[event.target.name][23][28][33].

**Example:**
const [form, setForm] = useState({ name: "", email: "" });
const handleChange = (e) =>
setForm({ ...form, [e.target.name]: e.target.value });



## Submitting Forms in React

To submit a form in React:
- Add an `onSubmit` handler to the `<form>` element.
- Prevent the default browser behavior with `event.preventDefault()`.
- Use state to access submitted data, validate it, and perform actions (like sending to a server).
- Optionally reset state or show confirmation[23][45].

**Example:**
const handleSubmit = (event) => {
event.preventDefault();
// Use form data here
};

<form onSubmit={handleSubmit}>...</form> ```
React forms provide a robust, flexible foundation for handling user input, enforcing validation, displaying feedback, and processing data without page reloads.
