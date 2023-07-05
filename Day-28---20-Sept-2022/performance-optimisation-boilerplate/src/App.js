import './App.css';
import { BrowserRouter as Router } from 'react-router-dom';
import React from 'react';


const ParentComponent = React.lazy(() => import('./CallBack/Parent'));

function App() {
  return (
    <div className="App">
      <Router>
        <React.Suspense fallback={<h3>Loading</h3>}>
          <ParentComponent />
        </React.Suspense>
      </Router>

    </div>
  );
}

export default App;
