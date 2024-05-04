import React from 'react';
import logo from '../assets/images/common/logo.png';
import Login_icon from '../assets/images/common/login.png'
import Wishlist_icon from '../assets/images/common/wishlist.png'
import Shoppingcart_icon from '../assets/images/common/shoppingcart.png'
import { Link } from 'react-router-dom';
import '../assets/css/header.css';

function Navbar({ onSearch }) {
  return (
    <div>
      <header className="header">
        {/* <!-- start of row 1 --> */}
        <div className="row1">
          {/* <!-- Search field --> */}
          <input
            type="text"
            className="search-field"
            placeholder="Search..."
            onChange={(e) => onSearch(e.target.value)}
          />

          {/* <!-- login--> */}
          <div className="login-container">
            <img className="login-icon" src={Login_icon} alt="login" />
            <Link to="/register">Register</Link>
          </div>
          {/* <!-- wishlist--> */}
          <div className="wishlist-container">
            <Link to="/wishlist_page">
              <img className="wishlist" src={Wishlist_icon} alt="Wishlist" />
            </Link>
          </div>
          {/* <!-- Shopping Cart --> */}
          <div className="cart-container">
            <Link to="/cart">
              <img className="shopping-cart-icon" src={Shoppingcart_icon} alt="shopping cart of this Website" />
            </Link>
          </div>
        </div> {/* <!-- end of row 1 --> */}
        {/* <!-- start of row 2 --> */}
        <div className="row2">
          {/* <!-- Logo --> */}
          <Link to="/">
            <img className="logo" src={logo} alt="Logo of this Website" />
          </Link>
          {/* <!-- Menu --> */}
          <nav>
            <Link to="/shop">Shop</Link>       {/* <!-- Shop routing --> */}
            <Link to="/about">About</Link>       {/* <!-- About us page routing --> */}
            <Link to="/contact">Contact</Link> {/* <!-- contacts routing --> */}
          </nav>
        </div> {/* <!-- end of row 2 --> */}
      </header>
    </div>
  );
}

export default Navbar;
