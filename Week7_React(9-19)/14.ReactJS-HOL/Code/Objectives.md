## Objectives

- Explain the need and benefits of React Context API
- Working with `createContext()`
- List the types of Router Components

---

## 1. Need and Benefits of React Context API

### Need
- **Avoid Prop Drilling:** In React, when passing data from parent to deeply nested child components, you normally use props. This can become cumbersome in large applications as you have to pass props through many levels. This is known as prop drilling.
- **Global State Management:** Context API allows sharing data that can be considered "global" within a React app (such as user authentication, theme, or language), without having to pass props at every level.

### Benefits
- **Simplifies State Management:** Makes managing and sharing state across the app easier and cleaner.
- **Reduces Boilerplate:** Less code compared to solutions like Redux; setting up and updating global state is straightforward.
- **Lightweight:** No external libraries are required for basic global state needs.
- **Multiple Contexts:** You can create multiple contexts for different types of data.
- **Scoped Context:** The data is only available within the Provider scopes where it is needed, reducing unnecessary renders.

---

## 2. Working with `createContext()`

- `createContext()` is a function provided by React that creates a new Context object.

### Basic Usage

#### 1. Create the Context
import React, { createContext } from 'react';

const MyContext = createContext(defaultValue);

text
- `defaultValue` is optional and is used if no matching Provider is found above in the tree.

#### 2. Use Provider to Supply the Value
<MyContext.Provider value={/* some value /}>
{/ All components that need the value go here */}
</MyContext.Provider>

text

#### 3. Consuming the Context Value
- **With useContext Hook** (modern functional components):
import { useContext } from 'react';
const value = useContext(MyContext);

text
- **With Consumer Component** (less common):
<MyContext.Consumer>
{value => /* render something based on the context value */}
</MyContext.Consumer>

text

---

## 3. Types of Router Components

React Router provides various types of routers for different environments and use cases:

| Name                | Purpose                                                        |
|---------------------|----------------------------------------------------------------|
| **BrowserRouter**   | Uses HTML5 History API; most commonly used for web apps.       |
| **HashRouter**      | Uses URL hash (`#`) for routing, useful for static sites.      |
| **MemoryRouter**    | Keeps history in memory (does not read/write to the address bar); used in testing or non-browser environments like React Native. |
| **StaticRouter**    | Used for server-side rendering (SSR), useful in Node.js apps.  |
| **NativeRouter**    | Used in React Native applications.                             |

**Other key Router components:**
- **Routes** and **Route:** For declaring individual routes.
- **Link** and **NavLink:** For navigation within the app.