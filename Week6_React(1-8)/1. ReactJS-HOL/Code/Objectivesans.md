# Introduction to ReactJS

## Objectives

- Understand what a Single Page Application (SPA) is and its advantages  
- Learn what React is and how it works  
- Know the differences between SPA and MPA (Multi Page Applications)  
- Discuss the pros and cons of SPAs  
- Explore how React works internally  
- Learn what the Virtual DOM is  
- Go over some key features of React  

---

## What is a SPA?

A SPA, or Single Page Application, is a type of web application that loads a single HTML page and dynamically updates the content as we interact with it. Instead of going to different pages and reloading everything each time, SPAs just change parts of the page as needed.

### Benefits:
- Faster interactions because the page doesn't reload
- Smooth user experience
- Uses less data after the initial load
- Often feels like using a mobile app

---

## What is React?

React is a popular JavaScript library created by Facebook for building user interfaces. It's mainly used for building SPAs.

### How it works:
- React breaks the UI into smaller parts called **components**.
- It uses something called the **Virtual DOM** to efficiently update only the parts of the webpage that actually changed.
- It's declarative — you describe what the UI should look like, and React handles the rest.

---

## SPA vs MPA

| Category       | SPA                                 | MPA                                      |
|----------------|--------------------------------------|-------------------------------------------|
| Page Load      | Loads once, content updates dynamically | Loads a new page every time you click     |
| Speed          | Faster after initial load            | Slower due to full reloads                |
| UX             | Feels smooth like an app             | Can feel a bit slower or jumpy            |
| SEO            | Harder to optimize                   | Easier for search engines                 |
| Example Apps   | Gmail, Facebook                      | Amazon, college websites                  |

---

## Pros and Cons of SPAs

### Pros:
- Fast and responsive
- Great for mobile-like experiences
- Easy to manage with APIs

### Cons:
- First load can be a bit slow
- Not always great for SEO
- Can get complicated for large projects

---

## What is the Virtual DOM?

The Virtual DOM is basically a copy of the real DOM that React keeps in memory. When something changes in the app, React updates the Virtual DOM first, compares it with the previous version, and only updates what’s necessary in the actual DOM. This makes things much faster and smoother.

---

## Key Features of React

- Component-based: we can reuse parts of your UI  
- Virtual DOM: Makes updates fast and efficient  
- One-way data flow: Helps keep data organized  
- Easy to test and debug  
- Works well with other tools and libraries  
- Large community and lots of support  

---
