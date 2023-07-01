import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Router, Routes} from "react-router-dom";
import ProductsTable from './components/ProductsTable'

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path= '/Tea/ProductsTable' element={<ProductsTable/>}/>
          <Route path='/'></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
