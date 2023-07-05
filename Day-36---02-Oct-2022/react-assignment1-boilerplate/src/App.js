import React from 'react';
import Dashboard from './component/Dashboard';
import './App.css';
import Footer from './component/Footer';
import Header from './component/Header';
class App extends React.Component {
  render() {

    return <div className='main-content' >
      <Header />
      <Dashboard />
      <Footer />
    </div>

  }
}
export default App;
