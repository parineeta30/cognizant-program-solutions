// src/GitClient.test.js
import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios'); // tells Jest to use __mocks__/axios.js

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const dummyRepos = [
      { id: 1, name: 'appscentricsolutions' },
      { id: 2, name: 'ArrayListDemo' },
      { id: 3, name: 'ArrayListDemo01' }
    ];

    axios.get.mockResolvedValue({ data: dummyRepos });

    const response = await GitClient.getRepositories('techiesyed');

    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
    expect(response.data).toEqual(dummyRepos);
  });
});
