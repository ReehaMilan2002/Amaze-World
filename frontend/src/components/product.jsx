//imports
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import red_heart from "../assets/images/products/red-heart.svg";
import white_heart from "../assets/images/products/heart.svg";
import "../assets/css/shop.css";

export const Product = ({ productId, AlterWishlist }) => {
  const [isAddedToWishlist, setIsAddedToWishlist] = useState(false);

  useEffect(() => {
    const isInWishlist = localStorage.getItem(`wishlist${productId}`);
    setIsAddedToWishlist(isInWishlist === 'true');
  }, [productId]);
    

  const handleClick = async () => {
    try {
      const WishlistState = !isAddedToWishlist;
      setIsAddedToWishlist(WishlistState);
      localStorage.setItem(`wishlist${productId}`, WishlistState );

     
      if (WishlistState ) {
        await axios.post(`http://localhost:8080/api/wishlist/add/${productId}`);
        console.log("product is added to wishlist");
      } else {
        await axios.delete(`http://localhost:8080/api/wishlist/remove/${productId}`);
        console.log("product is removed from wishlist");
      }
  
    
      AlterWishlist(productId);
    } catch (error) {
      console.error('Error altering the wishlist:', error);
    }
  };

  return (
    <div className="product">
      <button onClick={handleClick}>
        {isAddedToWishlist ? 
          <img className="wishlist_icon" src={red_heart} alt="Red Heart" /> : 
          <img src={white_heart} alt="White Heart" />}
      </button>
    </div>
  );
};

export default Product;