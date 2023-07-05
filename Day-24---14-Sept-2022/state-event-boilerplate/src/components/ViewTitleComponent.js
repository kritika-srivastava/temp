import React from 'react';

class ViewTitleComponent extends React.Component {
    // Define Constructor
    constructor(props) {
        super(props);
        this.handleValChange = this.handleValChange.bind(this);
    }

    // Define handleValChange method
    handleValChange({ target }) {

        //console.log("sample");
        this.props.handleChangeRef(target.value);
    }

    render() {
        return (
            <div className="ViewTitleComponent">
                <form>
                    <div>
                        <label>View Title:</label>
                        {/* Define input field to handle changes */}
                        <input type="text" onChange={this.handleValChange} />
                    </div>
                </form>
                <p>Title value: {this.props.input}</p>
            </div>
        );
    }
}
export default ViewTitleComponent;