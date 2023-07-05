import Adapter from 'enzyme-adapter-react-16';
import { shallow, configure } from 'enzyme';
import ChildComponent from '../LocalState/Child';

configure({adapter: new Adapter()});

test('Child should render text', async () => {
  const ChildComponentWrapper = shallow(<ChildComponent/>)
  const countValue= ChildComponentWrapper.find('#Child-Text')
  expect(countValue.text()).toContain('Child Component rendered')
})

