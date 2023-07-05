import App from '../App';
import React from 'react';
import Enzyme, { shallow } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';


Enzyme.configure({ adapter: new Adapter() });


// Scenario: Check if App component displays `Learn React!!` text in `h1` tag
test("Checking h1 content in APP", () => {

    const wrapper = shallow(<App />);
    expect(wrapper.find('h1').text()).toContain('Learn React!!');

})