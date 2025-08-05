## Objectives: 

### 1. Explain about Conditional Rendering in React

**Conditional rendering** refers to the process of dynamically displaying different content or components based on certain conditions (such as application state, props, or other logic). In React, conditional rendering works similarly to how conditions work in JavaScript. React evaluates JSX expressions and determines which elements to render.

#### Common patterns:

- **Using if statements:**
if (isLoggedIn) {
return <Dashboard />;
}
return <LoginForm />;


- **Using the ternary operator:**
{isAuthenticated ? <Profile /> : <SignIn />}


- **Logical AND (`&&`) operator:**
{showBanner && <BannerMessage />}


Conditional rendering allows you to display different UI sections or components without reloading the page, creating responsive and interactive applications.

---

### 2. Define Element Variables

In React, **element variables** refer to variables that store JSX elements or components. This allows you to assign, update, and reuse rendered content programmatically within your code.

#### Example:

let buttonElement;

if (isRegistered) {
buttonElement = <button>Log Out</button>;
} else {
buttonElement = <button>Sign Up</button>;
}

return <div>{buttonElement}</div>;


Element variables let you build up sections of the UI in advance and then include them in the resulting render, often improving clarity and flexibility when rendering complex or conditional elements.

---

### 3. Explain How to Prevent Components from Rendering

There are situations where you may want to **prevent a component or element from rendering** at all. In React, the most common and recommended way is to return `null` from a component’s render method or function body.

#### Examples:

- **Returning `null`:**

function Greeting({ isVisible }) {
if (!isVisible) {
return null; // Nothing is rendered to the DOM
}
return <h1>Hello, user!</h1>;
}

- **Conditional inclusion in JSX:**

{shouldDisplayComponent && <SomeComponent />}

If `shouldDisplayComponent` is `false`, `<SomeComponent />` is not rendered.

Returning `null` does not affect the rest of the component tree, and React handles it cleanly. This technique keeps the UI logic declarative and avoids unnecessary rendering of hidden or irrelevant UI sections.

---