// src/components/BookDetails.js
import React from "react";

const books = [
  { title: "Master React", price: 670 },
  { title: "Deep Dive into Angular 11", price: 800 },
  { title: "Mongo Essentials", price: 450 }
];

export default function BookDetails() {
  return (
    <div>
      <h1>Book Details</h1>
      <div style={{ marginTop: "2em" }}>
        <b>Master React</b>
        <div>670</div>
      </div>
      <div style={{ marginTop: "2em" }}>
        <b>Deep Dive into Angular 11</b>
        <div>800</div>
      </div>
      <div style={{ marginTop: "2em" }}>
        <b>Mongo Essentials</b>
        <div>450</div>
      </div>
    </div>
  );
}
