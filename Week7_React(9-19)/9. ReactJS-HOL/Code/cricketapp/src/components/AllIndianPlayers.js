// src/components/AllIndianPlayers.js
import React from 'react';

const T20Players = [
  'Mr. First Player',
  'Mr. Second Player',
  'Mr. Third Player',
];

const RanjiTrophyPlayers = [
  'Mr. Fourth Player',
  'Mr. Fifth Player',
  'Mr. Sixth Player',
];

const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

const AllIndianPlayers = () => {
  return (
    <div style={{ padding: 16 }}>
      <h1>List of Indian Players Merged:</h1>
      <ul>
        {IndianPlayers.map((player, idx) => (
          <li key={idx}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default AllIndianPlayers;
