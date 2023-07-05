import React from 'react';
import Adapter from 'enzyme-adapter-react-16';
import {  configure } from 'enzyme';
import { render, screen } from '@testing-library/react';
import Child1 from '../try-catch/Child1';


configure({adapter: new Adapter()});

test('Displays Child 1 error page', () => {
    render(<Child1/>);
    const nameElement = screen.getByText(/Fallback Page for Child1/);
    expect(nameElement).toBeInTheDocument();
});