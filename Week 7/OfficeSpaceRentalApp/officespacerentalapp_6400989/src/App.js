import React from 'react';
import './App.css';
import dbsImg from './dbs.jpg';
import regusImg from './regus.jpg';
import smartworksImg from './smartworks.jpg';

function App() {
  const element = "Office Space";

  const officeList = [
    { Name: "DBS", Rent: 50000, Address: "Chennai", image: dbsImg },
    { Name: "Regus", Rent: 65000, Address: "Bangalore", image: regusImg },
    { Name: "SmartWorks", Rent: 58000, Address: "Mumbai", image: smartworksImg }
  ];

  return (
      <div className="App">
        <h1>{element} , at Affordable Range</h1>
        <div className="card-container">
          {officeList.map((item, index) => {
            let rentColor = item.Rent <= 60000 ? "textRed" : "textGreen";
            return (
              <div key={index} className="card">
                <img src={item.image} alt={item.Name} />
                <h1>Name: {item.Name}</h1>
                <h3 className={rentColor}>Rent: Rs. {item.Rent}</h3>
                <h3>Address: {item.Address}</h3>
              </div>
            );
          })}
        </div>
      </div>
  );
}

export default App;
