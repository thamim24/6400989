import React from 'react';
import './App.css';
import Counter from './components/Counter';
import Welcome from './components/Welcome';
import SyntheticEventButton from './components/SyntheticEventButton';
import CurrencyConverter from './components/CurrencyConverter';

function App() {
  return (
    <div className="App">
      <section>
        <Counter />
        <Welcome />
        <SyntheticEventButton />
      </section>
      <section>
        <CurrencyConverter />
      </section>
    </div>
  );
}


export default App;
