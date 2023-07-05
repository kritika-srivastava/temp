import axios from 'axios';
import { useEffect, useState } from 'react';
import './App.css';
import AddProduct from './Components/AddProduct';
import ProductsData from './Components/ProductsData';
function App(props) {

  const [products, setproducts] = useState([]);
  let url = 'http://localhost:3001/products';


  const addProduct = (event, input) => {
    axios.post(url, input);
    window.location.reload(false);
  }

  const handleDelete = (event, id) => {
    axios.delete(url + `/${id}`);
    window.location.reload(false);
  }

  useEffect(() => {
    axios.get(url)
      .then((response) => {
        setproducts(response.data);
        console.log(products);
      })
  }, [])
  return (
    <div className="App">
      {
        <>
          <AddProduct addProduct={addProduct} />
          <ProductsData products={products} handleDelete={handleDelete} />
        </>
      }
    </div>
  );
}

export default App;
