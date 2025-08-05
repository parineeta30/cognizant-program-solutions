// src/components/ListofPlayers.js
import React from 'react';

const players = [
  { name: 'Mr. Jack', score: 50 },
  { name: 'Mr. Michael', score: 70 },
  { name: 'Mr. John', score: 40 },
  { name: 'Mr. Ann', score: 61 },
  { name: 'Mr. Elisabeth', score: 61 },
  { name: 'Mr. Sachin', score: 95 },
  { name: 'Mr. Dhoni', score: 100 },
  { name: 'Mr. Virat', score: 84 },
  { name: 'Mr. Jadeja', score: 64 },
  { name: 'Mr. Raina', score: 75 },
  { name: 'Mr. Rohit', score: 80 },
];

const ListofPlayers = () => {
  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div style={{ padding: 16 }}>
      <h1>List of Players</h1>
      <ul>
        {players.map((player, idx) => (
          <li key={idx}>
            {player.name} {player.score}
          </li>
        ))}
      </ul>

      <hr style={{ margin: '32px 0' }} />

      <h1>List of Players having Scores Less than 70</h1>
      <ul>
        {lowScorers.map((player, idx) => (
          <li key={idx}>
            {player.name} {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
