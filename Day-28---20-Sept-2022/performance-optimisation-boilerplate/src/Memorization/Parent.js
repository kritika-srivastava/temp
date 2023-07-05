// Replicate Parent component from `components/Parent.js` 
// to use Memorization method of performance optimization

// Make sure you use same tags and id value

import { useState } from 'react';
import ChildComponent from './Child';

function ParentComponent() {
    const [count, setCount] = useState(0);
    return (
        <div >
            <button id="count-btn" onClick={() => setCount(count + 1)}>Increament Count</button>
            <h2 id="count-value">Count value: {count}</h2>
            <ChildComponent></ChildComponent>
        </div>
    );
}

export default ParentComponent;