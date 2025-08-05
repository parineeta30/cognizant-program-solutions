// src/GitClient.js
import axios from 'axios';

class GitClient {
  static getRepositories(userName) {
    const url = `https://api.github.com/users/${userName}/repos`;
    return axios.get(url); // returns axios response object
  }
}

export default GitClient;
