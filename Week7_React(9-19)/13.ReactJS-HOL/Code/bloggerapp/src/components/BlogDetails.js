// src/components/BlogDetails.js
import React from "react";

export default function BlogDetails() {
  return (
    <div>
      <h1>Blog Details</h1>
      <div style={{ marginTop: "2em" }}>
        <b style={{ fontSize: 24 }}>React Learning</b>
        <div><b>Stephen Biz</b></div>
        <div>Welcome to learning React!</div>
      </div>
      <div style={{ marginTop: "2em" }}>
        <b style={{ fontSize: 24 }}>Installation</b>
        <div><b>Schwezdenier</b></div>
        <div>You can install React from npm.</div>
      </div>
    </div>
  );
}
