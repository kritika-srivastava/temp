import './App.css';
import BodyComponent from './components/BodyComponent';
import CommonComponent from './components/CommonComponent';
import HeaderComponent from './components/HeaderComponent';

function App() {
  return (
    <div className="App">
      <h1>learn react</h1>

      {< HeaderComponent />}

      {< BodyComponent />}

      {< CommonComponent text={"This is a Footer Content"} />}
    </div>
  );
}

export default App;
