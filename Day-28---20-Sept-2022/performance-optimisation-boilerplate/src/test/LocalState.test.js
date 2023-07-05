import { render } from '@testing-library/react';
import Adapter from 'enzyme-adapter-react-16';
import { shallow, configure } from 'enzyme';
import LocalState from '../LocalState/localstate';
import UserInput from '../LocalState/UserInput';

configure({adapter: new Adapter()});
jest.spyOn(console, 'log');

test('Child is rendered only once', async () => {
  render(<LocalState  />)
  const ParentComponentWrapper = shallow(<UserInput/>)
  const countButton = ParentComponentWrapper.find('#count-btn')
  countButton.simulate('click')
  countButton.simulate('click')
  countButton.simulate('click')
  expect(console.log.mock.calls.length).toBe(1);
  })

