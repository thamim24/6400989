import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(5);

  function sayHello() {
    alert("Hello! Member1");
  }

  function handleIncrement() {
    setCount(count + 1);
    sayHello();
  }

  function handleDecrement() {
    setCount(count - 1);
  }

  return (
    <div>
      <p>{count}</p>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={handleDecrement}>Decrement</button>
    </div>
  );
}

export default Counter;
