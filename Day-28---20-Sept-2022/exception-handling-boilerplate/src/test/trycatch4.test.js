import React from 'react';
import Adapter from 'enzyme-adapter-react-16';
import {  configure } from 'enzyme';
import { render, screen } from '@testing-library/react';
import Child2 from '../try-catch/Child2';


configure({adapter: new Adapter()});

test('Displays Child 2 content', () => {
    render(<Child2 locality="Bengaluru"/>);
    const nameElement = screen.getByText(/In locality: BENGALURU/);
    expect(nameElement).toBeInTheDocument();
});