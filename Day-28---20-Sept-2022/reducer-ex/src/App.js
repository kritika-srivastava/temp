import logo from './logo.svg';
import './App.css';
import { GlobalHandler } from './context/GlobalHandler';
import { BrowserRouter, Routes } from 'react-router-dom';
import Header from './components/Header';
import EditContact from './components/EditContact';
import AddContact from './components/AddContact';
import ContactList from './components/ContactList';

function App() {
  return (

    <GlobalHandler>
      <BrowserRouter>
        <Routes>
          <Routes path='/add' element={<AddContact />} />
          <Routes path='/edit/:id' element={<EditContact />} />
          <Routes path='/' element={<ContactList />} />

        </Routes>
      </BrowserRouter>
    </GlobalHandler >
  );
}

export default App;
