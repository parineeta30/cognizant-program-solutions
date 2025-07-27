import React, { Component } from 'react';
import Post from '../Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  // 6. loadPosts method
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => response.json())
      .then((data) => {
        const postList = data.map((item) => new Post(item.id, item.title, item.body));
        this.setState({ posts: postList });
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
      });
  };

  // 7. componentDidMount hook
  componentDidMount() {
    this.loadPosts();
  }

  // 9. componentDidCatch hook
  componentDidCatch(error, info) {
    alert('An error occurred in Posts component: ' + error);
    console.error(error, info);
  }

  // 8. render method
  render() {
    return (
      <div>
        <h2>All Blog Posts</h2>
        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
