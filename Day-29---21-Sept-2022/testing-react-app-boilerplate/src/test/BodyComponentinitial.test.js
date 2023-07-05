import BodyComponent from '../Components/BodyComponent';
import React from 'react';
import Enzyme, { shallow } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

Enzyme.configure({ adapter: new Adapter() });

// Scenario: Check if state value is set to `John` by default
test('Initial value of state to be John', () => {
    const wrapper = shallow(<BodyComponent />);
    expect(wrapper.instance().state.value).toBe('John');
});