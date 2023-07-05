// Replicate Parent component from `components/Parent.js` 
// to use LocalState method of performance optimization

// Make sure you use same tags and id value

import { useState } from 'react';

function ParentComponent() {
    const [count, setCount] = useState(0);
    return (
        <div >
            <button id="count-btn" onClick={() => setCount(count + 1)}>Increament Count</button>
            <h2 id="count-value">Count value: {count}</h2>
        </div>
    );
}

export default ParentComponent;