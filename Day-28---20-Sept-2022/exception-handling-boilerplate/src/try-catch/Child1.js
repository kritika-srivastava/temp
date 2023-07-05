import Fallback1 from "./FallBackChild1"

export default function Child1({ name }) {
    try {
        return (

            <div>
                <h1>Name of user: {name.toUpperCase()}</h1>
            </div>
        )
    }
    catch (error) {
        return <Fallback1 error={error} />
    }
}