import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('Euro');
  const [result, setResult] = useState(null);

  // Example conversion rate: 1 Euro = 80 INR
  const conversionRate = 80;

  // Handles form submit, performs conversion INR -> Euro
  const handleSubmit = (e) => {
    e.preventDefault();
    if (currency === 'Euro' && !isNaN(amount) && amount !== '') {
      const euroAmount = (parseFloat(amount) / conversionRate).toFixed(2);
      alert(`Converting to Euro Amount is ${euroAmount}`);
      setResult(euroAmount);
    } else {
      alert('Please enter a valid amount');
    }
  };

  return (
    <div style={{ margin: 32 }}>
      <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            Amount:
            <input
              type="number"
              value={amount}
              onChange={(e) => setAmount(e.target.value)}
              style={{ marginLeft: 8 }}
            />
          </label>
        </div>
        <div>
          <label>
            Currency:
            <select
              value={currency}
              onChange={(e) => setCurrency(e.target.value)}
              style={{ marginLeft: 8 }}
            >
              <option value="Euro">Euro</option>
              {/* Add more options if needed */}
            </select>
          </label>
        </div>
        <button type="submit" style={{ marginTop: 8 }}>
          Convert
        </button>
      </form>
      {result && (
        <div style={{ marginTop: 16 }}>
          <b>Euro Amount: €{result}</b>
        </div>
      )}
    </div>
  );
};

export default CurrencyConvertor;
