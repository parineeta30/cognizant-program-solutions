// src/App.js
import React from 'react';
import ListofPlayers from './components/ListofPlayers';
import OddEvenPlayers from './components/OddEvenPlayers';
import AllIndianPlayers from './components/AllIndianPlayers';

function App() {
  const flag = false; // Set this to false to see the other components

  if (flag === true) {
    // When flag is true - show ListofPlayers output
    return (
      <div>
        <ListofPlayers />
      </div>
    );
  } else {
    // When flag is false - show odd/even players and merged players
    return (
      <div>
        <OddEvenPlayers />
        <hr />
        <AllIndianPlayers />
      </div>
    );
  }
}

export default App;
