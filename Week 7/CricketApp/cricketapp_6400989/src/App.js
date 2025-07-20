import React, { useState } from "react";
import "./App.css";
import ListofPlayers from "./components/ListofPlayers";
import Scorebelow70 from "./components/Scorebelow70";
import OddPlayers from "./components/OddPlayers";
import EvenPlayers from "./components/EvenPlayers";
import ListofIndianPlayers from "./components/ListofIndianPlayers";

// Player list with scores
const players = [
  { name: "Jack", score: 50 },
  { name: "Michael", score: 70 },
  { name: "John", score: 40 },
  { name: "Ann", score: 61 },
  { name: "Elisabeth", score: 61 },
  { name: "Sachin", score: 95 },
  { name: "Dhoni", score: 100 },
  { name: "Virat", score: 84 },
  { name: "Jadeja", score: 64 },
  { name: "Raina", score: 75 },
  { name: "Rohit", score: 80 },
];

// Actual Indian player names with numbered suffix
const IndianPlayers = [
  "Sachin 1",
  "Dhoni 2",
  "Virat 3",
  "Rohit 4",
  "Yuvarajs 5",
  "Raina 6"
];

export default function App() {
  const [flag, setFlag] = useState(true);

  const handleToggle = () => {
    setFlag((prev) => !prev);
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial, sans-serif" }}>
      <button onClick={handleToggle} className="toggle-button">
        Toggle View
      </button>

      <p>Current flag value: <strong>{flag.toString()}</strong></p>
      {flag ? (
        <>
          <h1>List of Players</h1>
          <ListofPlayers players={players} />
          <hr />
          <h1>List of Players having Scores Less than 70</h1>
          <Scorebelow70 players={players} />
        </>
      ) : (
        <>
          <h1>Indian Team</h1>
          <h2>Odd Players</h2>
          <OddPlayers players={IndianPlayers} />
          <hr />
          <h2>Even Players</h2>
          <EvenPlayers players={IndianPlayers} />
          <hr />
          <h2>List of Indian Players Merged:</h2>
          <ListofIndianPlayers IndianPlayers={IndianPlayers} />
        </>
      )}
    </div>
  );
}
