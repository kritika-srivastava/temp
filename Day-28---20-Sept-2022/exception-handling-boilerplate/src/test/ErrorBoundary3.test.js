import React from 'react';
import Adapter from 'enzyme-adapter-react-16';
import {  configure } from 'enzyme';
import { render, screen } from '@testing-library/react';
import Child2 from '../Components/Child2';
import {ErrorBoundary} from 'react-error-boundary'
import Fallback2 from '../Components/Fallback2';


configure({adapter: new Adapter()});

test('Displays Child 2 fallback error boundary', () => {
    render(<ErrorBoundary FallbackComponent={Fallback2}>
        <Child2 ></Child2>
    </ErrorBoundary>);
    const nameElement = screen.getByText(/Fallback Page for Page-2/);
    expect(nameElement).toBeInTheDocument();
});