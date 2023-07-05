import './Body.css';

function BodyContentComponent(props) {
    return (
        <div className="BodyContent">

            <h4>{props.content}</h4>
        </div>
    );
}


export default BodyContentComponent;