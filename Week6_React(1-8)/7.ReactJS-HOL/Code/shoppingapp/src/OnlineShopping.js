// src/OnlineShopping.js
import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  render() {
    // Define your shopping items array
    const CartInfo = [
      { itemname: "Laptop", price: 80000 },
      { itemname: "TV", price: 120000 },
      { itemname: "Washing Machine", price: 50000 },
      { itemname: "Mobile", price: 30000 },
      { itemname: "Fridge", price: 70000 }
    ];

    return (
      <div className="mydiv" style={{ textAlign: 'center', marginTop: '20px' }}>
        <h2>Items Ordered :</h2>
        <table 
          style={{ margin: '0 auto', borderCollapse: 'collapse', width: '320px' }} 
          border="1"
        >
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            <Cart items={CartInfo} />
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
