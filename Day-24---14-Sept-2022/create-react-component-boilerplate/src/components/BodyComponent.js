import BodyLeft from "./BodyComponent/BodyLeftComponent/BodyLeft";
import BodyRight from "./BodyComponent/BodyRightComponent/BodyRight";

const BodyComponent = (props) => {
    return (
        <div>
            <h2>I am Body Component !!</h2>
            <BodyLeft />
            <BodyRight />
        </div>
    );
}
export default BodyComponent;