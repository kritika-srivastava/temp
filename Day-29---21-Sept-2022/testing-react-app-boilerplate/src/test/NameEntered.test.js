import BodyComponent from '../Components/BodyComponent';
import React from 'react';
import Enzyme, { mount, shallow, render } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

Enzyme.configure({ adapter: new Adapter() });

// Scenario: Check if Name entered field contains text as `Name Entered: John` by default
test('Initial value of Name entered field to be John', () => {
    const wrapper = shallow(<BodyComponent />);
    expect(wrapper.find('p').text()).toBe('Name Entered: John');
});