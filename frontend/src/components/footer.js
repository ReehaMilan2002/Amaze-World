import React from 'react'
import '../assets/css/footer.css'; 
import { Link } from 'react-router-dom';

const footer = () => {
  return (
    <div>
          <footer>
        <div className="footer-column">
        <Link to="/shop">Shop all</Link><br></br>
            <Link to="/about">About</Link><br></br>
            <Link to="/contact"> Contact</Link>
            
        </div>
        
        <div className="footer-column">
            <Link to="/shipReturn">Shipping & Return</Link><br></br>
            <Link to="/policy">Store Policy</Link><br></br>
            <Link to="/TermsAndConditions">Terms & Condition</Link><br></br>
            <Link to="/payment"> Payment Methods</Link>
            
        </div>
        <div className="footer-column">
            <div> Instagram </div>
            <div> Facebook</div>
            <div> Pinterest</div>
        </div>  
    </footer>
    <div className="copyright-notice">
        &copy; 2024 All Rights Reserved, Crafted Creations
    </div>   
      
    </div>
  )
}

export default footer
