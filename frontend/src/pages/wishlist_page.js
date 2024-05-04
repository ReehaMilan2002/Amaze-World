//imports
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import "../assets/css/wishlist.css";
import "../assets/css/wishlist_icon.css";
import Product from '../components/product';
const Wishlist_page = () => {
  const [wishlistItems, setWishlistItems] = useState([]);

  useEffect(() => {
    const getWishlistItems = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/wishlist');
        const fetchedWishlistItems = response.data;
        const postedWishlistItems = await Promise.all(fetchedWishlistItems.map(async (item) => {
          try {
            const image = await import(`../assets/images/bestsellers_carpet/${item.product.productImage}`);
            const image_location = image.default;
            return { ...item, product: { ...item.product, image_location } }; 
          } catch (error) {
            console.error('Error importing image:', error);
            return { ...item, product: { ...item.product, image_location : null } };
          }
        }));
        setWishlistItems(postedWishlistItems);
      } catch (error) {
        console.error('Error fetching wishlist items:', error);
      }
    };

    getWishlistItems();
  }, []);

  const AlterWishlist = async (productId) => {
    try {
      console.log('Altering the wishlist for productId:', productId);
      const postedWishlistItems = wishlistItems.filter(item => item.productId !== productId);
      setWishlistItems(postedWishlistItems);

    } catch (error) {
      console.error('Error in altering the wishlist:', error);
    }
  };
  

  return (
    <div className="container">
      <h1 className="wishlistTitle">Wishlist</h1>
      {wishlistItems.length > 0 ? (

        <div className="product-list">
          {wishlistItems.map(item => (
            <div key={item.id} className='product-item'>        
                <img className="product-image" src={item.product.image_location } alt={item.product.productName} />
                <div className="product-details">
                  <p className="product-name">{item.product.productName}</p>
                  <p className="product-price"> £{item.product.productPrice}</p>
                </div>
                <Product
                       productId={item.product.productId}
                       WishlistState ={true} 
                       AlterWishlist ={AlterWishlist }
                />
            </div>
          ))}
        </div>
    
      ) : (
        <div className="button-wrapper">
        <Link to="/shop" className="wishlist-empty">Back to Shop</Link>
      </div>
      )}
      </div>
     
  );
};

export default Wishlist_page;