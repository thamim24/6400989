import React from 'react';

function SyntheticEventButton() {
  function handleClick(e) {
    alert("I was clicked");
  }

  return (
    <div>
      <button onClick={handleClick}>Click on me</button>
    </div>
  );
}

export default SyntheticEventButton;
