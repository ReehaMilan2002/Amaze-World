//imports
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom'; // Import Link from react-router-dom for navigation
import { Product } from "../components/product";
import "../assets/css/shop.css";

const Shop = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const getProducts = async () => {
      try {
        const extract = await axios.get('http://localhost:8080/shop_page');
        const extractedProducts = extract.data;
        const updated = await Promise.all(extractedProducts.map(async (product) => {
          try {
            const image = await import(`../assets/images/bestsellers_carpet/${product.productImage}`);
            const imageLocation = image.default;
            return { ...product, imageLocation };
          } catch (error) {
            console.error('Error importing image:', error);
            return { ...product, imagelocation: null };
          }
        }));
        
        setProducts(updated);
      } catch (error) {
        console.error('Error fetching the products:', error);
      }
    };

    getProducts();
  }, []);

  const AlterWishlist = async (productId) => {
    try {
      console.log('Altering the wishlist for productId:', productId);
      const updatedProducts = products.map(product => {
        if (product.productId === productId) {
          return { ...product, isWishlist: !product.isWishlist };
        }
        return product;
      });
  
      setProducts(updatedProducts);  
      const WishlistState = updatedProducts.find(product => product.productId === productId).isWishlist;
      localStorage.setItem(`wishlist_${productId}`,WishlistState.toString());
    } catch (error) {
      console.error('Error in altering the  wishlist:', error);
    }
  };
  
  return (
    <div className="container">
      <h1 className="shopTitle">Shop</h1>
      <div className="productList">
        {products.map(product => (
          <div key={product.productId} className="productItem">
            {/* Wrap the image with an <a> tag for navigation */}
            <Link to={`/shop/${product.productId}`}>
              <img
                className="productImage"
                src={product.imageLocation} 
                alt={product.productName}
              />
            </Link>
            <div className="productDetails">
              <p className="productName">{product.productName}</p>
              <p className="productPrice">£{product.productPrice}</p>
            </div>
            
            <Product
              productId={product.productId} 
              AlterWishlist={AlterWishlist}
            />
            
          </div>
        ))}
      </div>
    </div>
  );
};

export default Shop;