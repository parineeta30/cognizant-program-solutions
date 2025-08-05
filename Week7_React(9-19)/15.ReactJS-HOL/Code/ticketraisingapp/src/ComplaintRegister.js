import React from "react";

class ComplaintRegister extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: "",
      complaint: "",
      NumberHolder: Math.floor(Math.random() * 100) + 1
    };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = (event) => {
    const { ename, NumberHolder } = this.state;
    const msg =
      "Thanks " +
      ename +
      "\nYour Complaint was Submitted.\nTransaction ID is: " +
      NumberHolder;
    alert(msg);
    event.preventDefault();
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "40px" }}>
        <h1 style={{ color: "red", fontWeight: "bold" }}>
          Register your complaints here!!!
        </h1>
        <form onSubmit={this.handleSubmit}>
          <div style={{ margin: "20px", fontSize: "22px" }}>
            <label style={{ marginRight: "10px" }}>Name:</label>
            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
              required
            />
          </div>
          <div style={{ margin: "20px", fontSize: "22px" }}>
            <label style={{ marginRight: "10px" }}>Complaint:</label>
            <textarea
              name="complaint"
              value={this.state.complaint}
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

export default ComplaintRegister;
