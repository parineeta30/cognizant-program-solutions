## Objectives:

### 1. Explain Various Ways of Conditional Rendering

**Conditional rendering** means displaying different UI elements or components based on dynamic logic or data. In React, there are several common methods:

- **If-Else Statements**  
  Use plain JavaScript if-else inside a render method or function:
if (isLoggedIn) {
return <UserDashboard />;
} else {
return <GuestPage />;
}



- **Ternary Operator**  
Embed inline logic for concise expressions:
{isVerified ? <VerifiedSection /> : <UnverifiedSection />}



- **Logical AND (`&&`) Operator**  
Render a component only if a condition is true:
{hasNotifications && <NotificationBar />}



- **Switch Statements**  
For multiple conditions:
switch (status) {
case 'loading': return <Loading />;
case 'error': return <Error />;
default: return <Content />;
}


---

### 2. Explain How to Render Multiple Components

You can **render multiple components** in React by returning them within a parent element or using React fragments:

function Page() {
return (
<div>
<Header />
<MainContent />
<Footer />
</div>
);
}

// Or using React fragments (no extra DOM node)
function Grouped() {
return (
<>
<Sidebar />
<Section />
</>
);
}


Components can also be rendered conditionally, inside arrays, or as results from map/filter functions.

---

### 3. Define List Component

A **list component** is a reusable React component designed to render collections of similar data. It typically receives an array of items (like objects) as a prop and uses `.map()` to generate child UI elements for each item.

#### Example:
function UserList({ users }) {
return (
<ul>
{users.map(user => (
<li key={user.id}>{user.name}</li>
))}
</ul>
);
}


List components help modularize code and manage dynamic datasets in the UI.

---

### 4. Explain About Keys in React Applications

**Keys** are special, unique identifiers assigned to items in a list. React uses keys to efficiently update and reorder items, tracking which elements have changed, been added, or removed.

- **Rules for Keys:**  
  - Keys must be unique among siblings.
  - Prefer stable IDs (like a DB id or unique property), not array indices if possible.
- **Purpose:**  
  - Keys help React optimize performance and maintain UI consistency.

#### Example:
const items = [{id: 1, value: 'A'}, {id: 2, value: 'B'}];
{items.map(item => <Item key={item.id} value={item.value} />)}


---

### 5. Explain How to Extract Components with Keys

  Should **extract a list item into a separate component** and provide keys at the top-level where mapping occurs, not inside the child component.

#### Example:
function ListItem({ value }) {
return <li>{value}</li>;
}

function ItemList({ items }) {
return (
<ul>
{items.map(item => <ListItem key={item.id} value={item.name} />)}
</ul>
);
}

Keys should always be applied to the component returned from `.map()`—not inside the ListItem definition itself.


### 6. Explain React Map, map() Function

In React, the `.map()` function is used to **iterate over arrays** and transform each element into a React element (JSX/component) for rendering.

**How it works:**
const numbers = ;
const listJSX = numbers.map(num => <li key={num}>{num}</li>);
// Output: [<li key="1">1</li>, <li key="2">2</li>, <li key="3">3</li>]


The result is an array of JSX elements, which can be rendered directly inside a component.

--