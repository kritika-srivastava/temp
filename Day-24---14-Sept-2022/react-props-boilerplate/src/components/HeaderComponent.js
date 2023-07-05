import React from "react";
import './Body.css';
import CommonComponent from "./CommonComponent";
import LogoComponent from "./LogoComponent";

class HeaderComponent extends React.Component {
    render() {
        const data = "This is a view title content";
        return (
            <div className="HeaderComponent">
                <h2> I am Header Component!!</h2>
                {<LogoComponent />}

                {<CommonComponent text={data} />}
            </div>
        );
    }
}
export default HeaderComponent;