# Objectives

- Explain the need for Unit Testing in React
- Working with Jest and Enzyme in React
- List the types of Router Components

---

## Need for Unit Testing in React

Unit testing is essential in React development for the following reasons:
- **Reliability:** Ensures individual components work as expected, reducing bugs in the UI and logic.
- **Maintainability:** Makes code easier to refactor and extend without introducing regressions.
- **Documentation:** Well-written tests provide usage examples and clarify expected component behavior.
- **Confidence:** Developers and teams can deploy updates with confidence, knowing automated tests will catch breaking changes.
- **Faster Debugging:** Pinpoints issues earlier in the development process, saving time and effort.

---

## Working with Jest and Enzyme in React

- **Jest** is the default testing framework bundled with Create React App. It’s used for running tests, making assertions, and generating code coverage reports.
  - Example test with Jest:
    ```
    test('renders welcome message', () => {
      render(<App />);
      expect(screen.getByText(/welcome/i)).toBeInTheDocument();
    });
    ```
- **Enzyme** is a utility for testing React components. It allows for shallow rendering, simulating events, and inspecting output.
  - Common Enzyme methods: `shallow()`, `mount()`, `simulate()`, and `.find()`.
  - Example with Enzyme:
    ```
    import { shallow } from 'enzyme';
    const wrapper = shallow(<MyComponent />);
    expect(wrapper.find('button').text()).toEqual('Submit');
    ```

---

## Types of Router Components

React Router provides several router components for different use cases:

| Router Component     | Description                                       |
|---------------------|---------------------------------------------------|
| **BrowserRouter**   | Uses the HTML5 History API for clean URLs in web apps. |
| **HashRouter**      | Uses the URL hash (`#`) for client-side routing, useful for static sites. |
| **MemoryRouter**    | Keeps navigation history in memory, ideal for tests or React Native. |
| **StaticRouter**    | Used for server-side rendering; the location is set programmatically. |
| **NativeRouter**    | Used with React Native applications.              |

---


