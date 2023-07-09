import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import ProductsTable from './components/ProductsTable'
import ProductForm from "./components/ProductForm";
import HomeComponent from "./components/HomeComponent";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path= '/Tea/ProductsTable' element={<ProductsTable/>}/>
          <Route path='/' element={<HomeComponent/>}/>
          <Route path=':ProductClass/EditProductPage/:id' element={<ProductForm/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
