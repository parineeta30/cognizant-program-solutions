// src/components/OddEvenPlayers.js
import React from 'react';

const IndianPlayers = [
  'Sachin1',
  'Dhoni2',
  'Virat3',
  'Rohit4',
  'Yuvaraj5',
  'Raina6',
];

// Destructuring odd and even players (positions: odd indices 0,2,4 and even indices 1,3,5)
const [odd1, even1, odd2, even2, odd3, even3] = IndianPlayers;

const OddEvenPlayers = () => {
  return (
    <div style={{ padding: 16 }}>
      <h1>Odd Players</h1>
      <ul>
        <li>First : {odd1}</li>
        <li>Third : {odd2}</li>
        <li>Fifth : {odd3}</li>
      </ul>

      <hr />

      <h1>Even Players</h1>
      <ul>
        <li>Second : {even1}</li>
        <li>Fourth : {even2}</li>
        <li>Sixth : {even3}</li>
      </ul>
    </div>
  );
};

export default OddEvenPlayers;
