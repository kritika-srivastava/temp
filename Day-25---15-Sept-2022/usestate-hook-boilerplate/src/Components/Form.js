import { useState } from "react";

function Form() {
    // Define name state value with default value 'Guest'
    const [name, setName] = useState("Guest");

    // Define handleValChange to set name state value to text entered in form
    function handleValChange(event) {
        setName(event.target.value);
    }

    return (
        <div>
            <form>
                <div>
                    {/* Call handleValChange on every text entered by user  (Done) */}
                    <label>Name:</label>
                    <input type="text" onChange={handleValChange} />
                </div>
            </form>
            {/* Display name state value (Done) */}
            <p id="name">Name value: {name}</p>
        </div>
    )
}

export default Form;