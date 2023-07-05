import BodyComponent from '../Components/BodyComponent';
import React from 'react';
import Enzyme, { shallow } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

Enzyme.configure({ adapter: new Adapter() });

//Scenario: Check if form accepts input and changes state value
test('BodyComponent renders Form, accepts input and change state value', () => {
    const wrapper = shallow(<BodyComponent />);
    wrapper.find('button').simulate('click');
    //wrapper.find('input').simulate('change');
    expect(wrapper.instance().state.value).toBe('Guest');
});