// src/components/UserPage.js
import React from "react";

const flightData = [
  { id: 1, flight: "AI-101", from: "Delhi", to: "Mumbai", time: "07:30", price: "₹6500" },
  { id: 2, flight: "6E-232", from: "Chennai", to: "Kolkata", time: "09:10", price: "₹7500" },
  { id: 3, flight: "SG-879", from: "Bangalore", to: "Hyderabad", time: "13:45", price: "₹4800" },
];

export default function UserPage({ onLogout }) {
  const bookTicket = (flight) => {
    alert(`Ticket booked for flight ${flight.flight} from ${flight.from} to ${flight.to}!`);
  };

  return (
    <div style={{ padding: 24 }}>
      <h2>Welcome, User! You can book tickets below.</h2>
      <h3>Available Flights</h3>
      <table border="1" cellPadding="8" style={{ marginBottom: 16 }}>
        <thead>
          <tr>
            <th>Flight</th>
            <th>From</th>
            <th>To</th>
            <th>Time</th>
            <th>Price</th>
            <th>Book</th>
          </tr>
        </thead>
        <tbody>
          {flightData.map((f) => (
            <tr key={f.id}>
              <td>{f.flight}</td>
              <td>{f.from}</td>
              <td>{f.to}</td>
              <td>{f.time}</td>
              <td>{f.price}</td>
              <td>
                <button onClick={() => bookTicket(f)}>Book Ticket</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button onClick={onLogout}>Logout</button>
    </div>
  );
}
