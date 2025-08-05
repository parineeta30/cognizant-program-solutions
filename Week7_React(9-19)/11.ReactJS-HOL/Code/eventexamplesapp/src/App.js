import React, { useState } from "react";

function App() {
  // Counter state
  const [count, setCount] = useState(1);

  // Currency converter state
  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("Euro");

  // For form submit
  const handleConvert = (e) => {
    e.preventDefault();
    // Example rate: 1 Euro = 80 INR
    if (currency === "Euro" && amount !== "" && !isNaN(amount)) {
      const result = Number(amount) * 80; // You can change the rate as required
      alert(`Converting to Euro Amount is ${result}`);
    } else {
      alert("Please enter a valid amount.");
    }
  };

  // Increment with 2 actions ("increment" + "say Hello" as per requirement)
  const handleIncrement = () => {
    setCount(count + 1);
    sayWelcome("Hello, counter increased!"); // Just as an example message
  };

  // Decrement only decrements
  const handleDecrement = () => {
    setCount(count - 1);
  };

  // Say welcome with argument (also for its own button)
  const sayWelcome = (message = "welcome") => {
    alert(message);
  };

  // Synthetic event: show alert onClick
  const handleSynthetic = () => {
    alert("I was clicked");
  };

  return (
    <div style={{ padding: 24 }}>
      {/* Counter */}
      <div style={{ marginBottom: 16 }}>{count}</div>
      <button onClick={handleIncrement}>Increment</button>
      <br />
      <button onClick={handleDecrement} style={{ marginTop: 8 }}>
        Decrement
      </button>
      <br />
      <button
        style={{ marginTop: 8 }}
        onClick={() => sayWelcome("welcome")}
      >
        Say welcome
      </button>
      <br />
      <button style={{ marginTop: 8 }} onClick={handleSynthetic}>
        Click on me
      </button>

      {/* Currency Convertor */}
      <h1 style={{ color: "green", marginTop: 28, fontSize: "2rem" }}>
        Currency Convertor!!!
      </h1>

      <form onSubmit={handleConvert}>
        <div style={{ marginBottom: 10 }}>
          Amount:
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            style={{ marginLeft: 8 }}
          />
        </div>
        <div style={{ marginBottom: 10 }}>
          Currency:
          <select
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
            style={{ marginLeft: 8 }}
          >
            <option value="Euro">Euro</option>
            {/* You can add more currencies here */}
          </select>
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
