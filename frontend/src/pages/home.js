//imports
import React from 'react';
import { useState, useEffect } from 'react';
import '../assets/css/home.css'; 
import { Link } from 'react-router-dom';
import carpet1 from "../assets/images/bestsellers_carpet/potbs1.png";
import carpet2 from "../assets/images/bestsellers_carpet/potbs2.png";
import carpet3 from "../assets/images/bestsellers_carpet/potbs3.png";
import artisan1 from "../assets/images/home/Artisan1.png";
import hp1 from "../assets/images/home/hp1.png";
import hp2 from "../assets/images/home/hp2.png";
import hp3 from "../assets/images/home/hp3.png";
import video1 from "../assets/videos/video1.mp4";
import video2 from "../assets/videos/video2.mp4";
import video3 from "../assets/videos/video3.mp4";
import "../assets/css/Modal.css"; // CSS for styling modal


function Home() {




  // homepage videos
    const videos_array = [video1, video2, video3];
    const [currentVideoIndex, setCurrentVideoIndex] = useState(0);
    useEffect(() => {
        const interval = setInterval(() => {
          setCurrentVideoIndex((prevIndex) => (prevIndex + 1) % videos_array.length);}, 5000); 
          return () => clearInterval(interval);
      }, [videos_array.length]);
      

     //terms and homepage  
  return (
    <div>




    {/* HTML code for the video container */}
     <div className="vide-container">
  {videos_array.map((video, index) => (
    <div key={index} className="video-wrapper" style={{ display: index === currentVideoIndex ? 'block' : 'none' }}>
      <video src={video} autoPlay muted loop className="video" />
      <div className="quote-container">
        <p className="quote">"Crafted by hand, cherished forever."</p>
      </div>
    </div>
  ))}
</div>

        
        <section className="bestseller-section">
        <h2>BEST SELLERS</h2>
        <div className="bestsellers-container">
            <div className="bestseller-item">
                <img className="carpets" src={carpet1} alt="Best Seller 1"/>
                <p>£60.00</p>
            </div>
            <div className="bestseller-item">
                <img className="carpets" src={carpet2} alt="Best Seller 2"/>
                <p>£69.55</p>
            </div>
            <div className="bestseller-item">
                <img className="carpets" src={carpet3} alt="Best Seller 3"/>
                <p>£65.00</p>
            </div>
        </div>
    
    {/*!-- Shop carpets button -->*/}
    <div className="button-wrapper">
      {/* Wrap the button in a Link component */}
      <Link to="/shop" className="shop-carpets">Shop Products</Link>
    </div>
    </section> 

     {/*<!-- 3rd page section content goes here, Artisans story-->*/}
     <section className="our-story-section">
        <div className="image-column">
            <img className="artisans slide-down" src={artisan1} alt="Artisans" />
        </div>
        <div className="text-column">
            <h2>Handcrafted Products</h2>
            <Link className="Story-page-link" to="/stories">Read our story</Link>
            <div id="artisans">
            </div>
        </div>
    </section>

    {/* <section className="picture-section"> */}
    {/* <div className="container"> */}
        <div className="image-container">
        {/* Replace the image sources with your actual image URLs */}
        <img src={hp1} alt="Aest2" />
        <img src={hp3} alt="Aest3" />
        <img src={hp2} alt="Aest4" />
        </div>
    {/* </div> */}
    {/* </section> */}

    <section className='text-strip'>
        <div>Worldwide Shipping </div>
        <div>Easy 30 day Return </div>
        <div>12 month warranty </div>
    </section>


    
  </div>
  )
}

export default Home;
