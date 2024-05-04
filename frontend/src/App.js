//imports
import './App.css';
import Navbar from './components/navbar';
import Footer from './components/footer';
import Home from './pages/home';
import {BrowserRouter, Route,Routes} from "react-router-dom";
import Wishlistpage  from './pages/wishlist_page.js';
import Shop from './pages/shop.jsx';
import ScrollToTop from './components/ScrollToTop';

import ShipReuturns from './pages/shipReturnPage.jsx';



function App() {

  return (
    <div className="App">

      <BrowserRouter>
      <ScrollToTop />
      <Navbar/>
      {/* <ShopContextProvider> */}
     <Routes>
        <Route index element={<Home/>}/>
          <Route path="/wishlist_page" element={<Wishlistpage />}/>
          <Route path="/shop" element={<Shop/>}/>
          {/* <Route path="/register" element={<Register/>}/> */}
          {/* <Route path="/cart" element={<Cart/>}/> */}
          <Route path="/shipReturn" element={<ShipReuturns/>}/>
          {/* <Route path="/about" element={<AboutUsPage />} /> */}
       </Routes>
       {/* </ShopContextProvider> */}
       <Footer/>
       </BrowserRouter>

  
    </div>

  );
}

export default App;