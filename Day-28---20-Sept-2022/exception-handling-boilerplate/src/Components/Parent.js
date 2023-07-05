import { ErrorBoundary } from "react-error-boundary";
import Child1 from "../try-catch/Child1";
import Child2 from "../try-catch/Child2";
import Fallback1 from "./Fallback1";
import Fallback2 from "./Fallback2";

function Parent() {
    return (
        <div>
            <ErrorBoundary FallbackComponent={Fallback1}>
                <Child1 />
            </ErrorBoundary>
            <ErrorBoundary FallbackComponent={Fallback2}>
                <Child2 />
            </ErrorBoundary>
        </div >
    )
}

export default Parent;