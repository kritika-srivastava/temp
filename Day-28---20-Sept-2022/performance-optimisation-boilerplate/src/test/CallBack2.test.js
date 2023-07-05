import Adapter from 'enzyme-adapter-react-16';
import { shallow, configure } from 'enzyme';
import ParentComponent from '../CallBack/Parent';

configure({adapter: new Adapter()});

test('Count value increments when button is clicked', async () => {
  const ParentComponentWrapper = shallow(<ParentComponent/>)
  ParentComponentWrapper.find('button').simulate('click');
  ParentComponentWrapper.find('button').simulate('click');
  ParentComponentWrapper.find('button').simulate('click');
  const countValue= ParentComponentWrapper.find('#count-value')
  expect(countValue.text()).toContain('Count value: 3')
})

