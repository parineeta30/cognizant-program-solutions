// src/Cart.js
import React, { Component } from 'react';

class Cart extends Component {
  render() {
    const { items } = this.props;

    return (
      <>
        {items.map((item, index) => (
          <tr key={index}>
            <td>{item.itemname}</td>
            <td>{item.price}</td>
          </tr>
        ))}
      </>
    );
  }
}

export default Cart;
