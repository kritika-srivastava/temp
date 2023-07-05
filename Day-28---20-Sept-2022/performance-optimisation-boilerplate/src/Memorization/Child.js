// Replicate child component from `components/Child.js` 
// to use Memorization method of performance optimization

// Make sure you use same tags and id value

import React from 'react';

const ChildComponent = React.memo(function ChildComponent() {
    console.log("Child Component is rendering");
    return <div id="Child-Text">Child Component rendered</div>
});

export default ChildComponent;