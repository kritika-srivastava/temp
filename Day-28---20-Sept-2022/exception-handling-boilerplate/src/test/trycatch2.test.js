import React from 'react';
import Adapter from 'enzyme-adapter-react-16';
import {  configure } from 'enzyme';
import { render, screen } from '@testing-library/react';
import Child1 from '../try-catch/Child1';


configure({adapter: new Adapter()});

test('Displays Child 1 content', () => {
    render(<Child1 name="Charlie"/>);
    const nameElement = screen.getByText(/Name of user: CHARLIE/);
    expect(nameElement).toBeInTheDocument();
});