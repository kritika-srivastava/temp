import BodyComponent from '../Components/BodyComponent';
import React from 'react';
import Enzyme, { mount, shallow, render } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

Enzyme.configure({ adapter: new Adapter() });

//Scenario: Check if Name Entered field contains `Name Entered: Guest` when `button` is clicked
test('BodyComponent changes state value to default when clicked', () => {
    const wrapper = shallow(<BodyComponent />);
    wrapper.find('button').simulate('click');
    expect(wrapper.find('p').text()).toBe('Name Entered: Guest');

});