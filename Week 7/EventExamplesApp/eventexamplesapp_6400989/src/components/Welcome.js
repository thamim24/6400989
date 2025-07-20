import React from 'react';

function Welcome() {
  function sayWelcome(message) {
    alert(message);
  }

  return (
    <div>
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
    </div>
  );
}

export default Welcome;
