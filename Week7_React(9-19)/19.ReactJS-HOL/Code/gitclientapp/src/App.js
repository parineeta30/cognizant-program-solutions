// src/App.js
import './App.css';
import { useEffect, useState } from 'react';
import GitClient from './GitClient';

function App() {
  const [repositories, setRepositories] = useState([]);

  useEffect(() => {
    GitClient.getRepositories('techiesyed')
      .then((response) => {
        setRepositories(response.data); // response.data is an array of repos
      })
      .catch((error) => {
        console.error('Error fetching repositories:', error);
      });
  }, []);

  return (
    <div className="App" style={{ textAlign: 'center', padding: '20px' }}>
      <h1>Git repositories of User - TechieSyed</h1>
      {repositories.map((repo) => (
        <p key={repo.id}>{repo.name}</p>
      ))}
    </div>
  );
}

export default App;
