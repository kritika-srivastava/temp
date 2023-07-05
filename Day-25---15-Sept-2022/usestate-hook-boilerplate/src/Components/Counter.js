import { useState } from "react";

function Counter() {
    // Define count state value with default value 0
    const [count, setCount] = useState(0);

    // Define name state value with default value 'Guest'
    const [name, setName] = useState('Guest');

    // Define handleIncrement to increment count state value by 1
    function handleIncrement() {
        setCount(count + 1);
    }

    // Define handleDecrement to decrement count state value by 1
    function handleDecrement() {
        setCount(count - 1);
    }

    // Define handleNameChange to change name state value to 'Charlie
    function handleNameChange() {
        setName('Charlie');
    }

    return (
        <div>
            {/* Display Hi {name} (Done) */}
            <h2 id="greet">Hi {name}</h2>

            {/* Call handleDecrement when clicked (Done) */}
            <button id="dec" onClick={handleDecrement}>-</button>

            <span id="cnt">Count: {count}</span>

            {/* Call handleIncrement when clicked (Done) */}
            <button id="inc" onClick={handleIncrement}>+</button>
            <br />
            <br />
            {/* Call handleNameChange when clicked (Done) */}
            <button id="cgName" onClick={handleNameChange}>Change Name</button>
        </div>
    )
}

export default Counter;