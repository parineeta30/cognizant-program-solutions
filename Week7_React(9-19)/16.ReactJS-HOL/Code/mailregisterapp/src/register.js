import React from "react";

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: "",
      email: "",
      password: "",
      errors: {
        fullName: "",
        email: "",
        password: ""
      }
    };
  }

  validateForm = (errors) => {
    return Object.values(errors).every((val) => val === "");
  };

  handleChange = (event) => {
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName = value.length < 5 ? 'Full Name must be 5 characters long!' : '';
        break;
      case 'email':
        // This regex checks for an email pattern
        const validEmailRegex = RegExp(
          /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\\.,;:\s@\"]+\.)+[^<>()[\]\\.,;:\s@\"]{2,})$/i
        );
        errors.email = validEmailRegex.test(value)
          ? ''
          : 'Email is not valid!';
        break;
      case 'password':
        errors.password = value.length < 8 ? 'Password must be 8 characters long!' : '';
        break;
      default:
        break;
    }

    this.setState({ [name]: value, errors });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    if (this.validateForm(this.state.errors)) {
      alert('Valid Form');
    } else {
      if (this.state.errors.fullName !== "") {
        alert(this.state.errors.fullName);
      }
      if (this.state.errors.email !== "") {
        alert(this.state.errors.email);
      }
      if (this.state.errors.password !== "") {
        alert(this.state.errors.password);
      }
    }
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h1 style={{ color: "red", fontWeight: "bold" }}>Register Here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <div style={{ fontSize: "22px", margin: "10px" }}>
            <label style={{ marginRight: "10px" }}>Name:</label>
            <input
              type="text"
              name="fullName"
              value={this.state.fullName}
              onChange={this.handleChange}
              required
            />
          </div>
          <div style={{ fontSize: "22px", margin: "10px" }}>
            <label style={{ marginRight: "10px" }}>Email:</label>
            <input
              type="email"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
              required
            />
          </div>
          <div style={{ fontSize: "22px", margin: "10px" }}>
            <label style={{ marginRight: "10px" }}>Password:</label>
            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
              required
            />
          </div>
          <button type="submit" style={{ fontSize: "18px" }}>
            Submit
          </button>
        </form>
      </div>
    );
  }
}

export default Register;
