# Objectives

- Explain how to consume REST APIs from React applications


## Consuming REST APIs from React Applications

Consuming REST APIs from React allows your application to dynamically retrieve, display, and interact with external data sources, such as databases or third-party services. Here’s how it’s typically achieved:

### 1. Using the `fetch` API

- React applications can use the built-in `fetch` method to send HTTP requests (GET, POST, PUT, DELETE) to REST API endpoints.
- The response data is usually parsed as JSON and used to update the React component’s state.

**Example:**
useEffect(() => {
fetch('https://api.example.com/data')
.then(response => response.json())
.then(data => setData(data))
.catch(error => console.error('Error:', error));
}, []);



### 2. Using Axios

- Axios is a popular third-party library for handling HTTP requests in JavaScript, including React. It simplifies API interaction and supports features like interceptors.

**Example:**
import axios from 'axios';

useEffect(() => {
axios.get('https://api.example.com/data')
.then(response => setData(response.data))
.catch(error => console.error('Error:', error));
}, []);



### 3. Managing State and Side Effects

- API data is usually stored in local state using hooks like `useState`.
- Side effects, such as fetching data when a component mounts, are managed with the `useEffect` hook in function components.

### 4. Error Handling

- Always handle loading and error states to provide good user feedback and robust applications.

**Example Snippet:**
const [data, setData] = useState(null);
const [error, setError] = useState(null);
const [loading, setLoading] = useState(false);

useEffect(() => {
setLoading(true);
fetch('https://api.example.com/data')
.then(res => res.json())
.then(data => setData(data))
.catch(setError)
.finally(() => setLoading(false));
}, []);



### 5. Displaying Data

- Once data is fetched and set into state, it can be displayed directly in your React components inside JSX.

---
