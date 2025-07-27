## Objectives
· Explain the need and benefits of React Router
· Identify the Components in React Router
· List the types of Router Components
· Parameter passing via url


1. Need and Benefits of React Router
# Why is React Router needed?
React itself does not provide built-in routing. To create modern, single-page applications (SPAs) that have multiple pages or views but no page reloads, you need a system to control navigation and which components are shown for which URL.
React Router lets to map URLs to components, enabling deep links, browser back/forward button support, and bookmarkable URLs—all essential for web apps.
Benefits:
Declarative Routing: Define what UI should show for each URL directly in your React code.

Seamless Navigation: Change views/components without a full page reload, resulting in a faster and smoother user experience.

Browser History Support: Built-in support for browser navigation buttons and history.

Dynamic Routing: Easily build routes that adapt to app state or user actions.

URL Management: URLs can represent the current view, making sharing and deep linking possible.

Code Organization: Because routing is handled via components, it matches React’s philosophy and makes code modular and reusable.

2. Components in React Router
Essential React Router components include:

**Component**	                        **Purpose**
BrowserRouter	              Uses browser history API for clean URLs (main router)
HashRouter	                  Uses URL hash (#) for routes; useful for static hosts
Route	                      Maps a specific path to a React component
Routes	                      Container for grouping multiple Route definitions
Link	                      Navigation UI component for changing routes without full reload
NavLink	                      Like Link, but adds styling for "active" routes
useNavigate / withRouter	  Programmatic navigation and access to router info
3. Types of Router Components
There are several types of router components available, each for specific use cases:

**Router Type**                	**When/Why to Use**
BrowserRouter	        For most web apps (uses normal URL paths, requires server setup)
HashRouter	            For static sites or basic deployments (uses # in URL)
MemoryRouter	        For non-browser environments (ex: testing, React Native)
StaticRouter	        For server-side rendering (SSR), mostly used with frameworks
NativeRouter	        For React Native apps


4. Parameter Passing via URL
How to define parameters: In a <Route>, use the colon (:) syntax in the path for parameters.
Eg: 
jsx
<Route path="/user/:id" element={<UserProfile />} />


How to access parameters in the component: Use the useParams hook from react-router-dom:

jsx
import { useParams } from 'react-router-dom';
const UserProfile = () => {
  const { id } = useParams(); // Extracts 'id' from URL
  return <h1>User ID: {id}</h1>;
}


How to navigate with parameters:
jsx
<Link to="/user/123">Go to User 123</Link>

Multiple parameters example:

jsx
<Route path="/user/:userId/post/:postId" element={<Post />} />
// useParams will return { userId, postId }