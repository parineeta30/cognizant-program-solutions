import React from "react";

// Sample array of office objects
const offices = [
  {
    name: "DBS",
    rent: 50000,
    address: "Chennai",
    img: "https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=400&q=80"
  },
  {
    name: "WeWork",
    rent: 75000,
    address: "Bangalore",
    img: "https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=400&q=80"
  },
  {
    name: "SmartOffice",
    rent: 45000,
    address: "Pune",
    img: "https://images.unsplash.com/photo-1464983953574-0892a716854b?auto=format&fit=crop&w=400&q=80"
  }
];

// CSS classes as JS objects
const styles = {
  rentHigh: { color: "green", fontWeight: "bold" },
  rentLow: { color: "red", fontWeight: "bold" },
  img: { width: "200px", height: "auto", borderRadius: "8px", marginBottom: "1rem" },
  officeCard: { background: "#f5f5f5", margin: "24px 0", padding: "20px", borderRadius: "12px", maxWidth: "400px" }
};

const OfficeList = () => {
  return (
    <div style={{ padding: "2rem" }}>
      {/* Heading */}
      <h1>Office Space, at Affordable Range</h1>
      {/* Loop through each office */}
      {offices.map((office, idx) => (
        <div key={idx} style={styles.officeCard}>
          {/* Image */}
          <img src={office.img} alt="Office Space" style={styles.img} />
          {/* Office Details */}
          <h2>Name: {office.name}</h2>
          <h3 style={office.rent <= 60000 ? styles.rentLow : styles.rentHigh}>
            Rent: Rs. {office.rent}
          </h3>
          <h3>Address: {office.address}</h3>
        </div>
      ))}
    </div>
  );
};

export default OfficeList;
