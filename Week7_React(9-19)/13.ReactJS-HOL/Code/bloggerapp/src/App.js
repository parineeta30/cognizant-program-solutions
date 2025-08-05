// src/App.js
import React from "react";
import CourseDetails from "./components/CourseDetails";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";

function App() {
  return (
    <div
      style={{
        display: "flex",
        justifyContent: "space-around",
        alignItems: "stretch",
        marginTop: 40,
        padding: "0 60px",
      }}
    >
      <div style={{ flex: 1 }}>
        <CourseDetails />
      </div>
      <div
        style={{
          flex: 1,
          borderLeft: "5px solid green",
          borderRight: "5px solid green",
          margin: "0 32px",
          paddingLeft: 32,
          paddingRight: 32,
        }}
      >
        <BookDetails />
      </div>
      <div style={{ flex: 1 }}>
        <BlogDetails />
      </div>
    </div>
  );
}

export default App;
