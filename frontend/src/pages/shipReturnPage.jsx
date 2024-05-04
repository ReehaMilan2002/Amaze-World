import React, { PureComponent } from 'react';
import '../assets/css/ShipReturnPage.css'; // Adjust the path to your CSS file for styling
import ShipReturnsImage from '../assets/images/extras/ShipReturns.png'; // Adjust the path to your image file

export class ShipReturnPage extends PureComponent {
  constructor(props) {
    super(props);
    this.state = {
      activeTab: null,
      tabs: [
        {
          id: 1,
          title: 'Shipping Information',
          content: "We are proud to offer worldwide shipping for all our products, including our exquisite carpets. Whether you're located across the globe or just around the corner, we ensure prompt delivery of your orders. Our dedicated team works tirelessly to package and ship your carpets with the utmost care, ensuring they arrive at your doorstep in pristine condition. With our reliable shipping services, you can trust that your purchase will reach you securely and efficiently, no matter where you are in the world. Experience the convenience of shopping with us and adorn your home with our stunning collection of carpets, delivered straight to you."
        },
        {
          id: 2,
          title: 'Returns Policy',
          content: "We understand that sometimes a product may not meet your expectations, and we want you to be completely satisfied with your purchase. That's why we offer a hassle-free return policy. If for any reason you're not delighted with your carpet, you can return it within 30 days of receipt for a full refund. Simply ensure the carpet is unused and in its original condition, and we'll take care of the rest. To initiate a return, please contact our customer service team, and they'll guide you through the process. Please note that return shipping costs are the responsibility of the customer, except in cases where the item is defective or damaged upon receipt. We value your satisfaction and strive to make your shopping experience with us as enjoyable as possible."
        },
        {
          id: 3,
          title: 'Contact Us',
          content: "If you have any questions or concerns regarding our products, shipping, or returns, please don't hesitate to reach out to us. Our dedicated customer service team is here to assist you every step of the way. You can contact us via email at support@example.com or by phone at +1-123-456-7890. We're available during our business hours from Monday to Friday, 9 AM to 5 PM (UTC). Whether you need assistance with product inquiries, order tracking, or any other queries, we're committed to providing you with prompt and helpful support. Your satisfaction is our top priority, and we look forward to hearing from you!"
        }
      ]
    };
  }

  handleTabClick = (tabId) => {
    this.setState({ activeTab: tabId });
  }

  render() {
    const { tabs, activeTab } = this.state;

    return (
      <div className="ship-return-page">
        <h1 className="shipReturnTitle">Shipping and Returns</h1>
        <img src={ShipReturnsImage} alt="Shipping and Returns" className="shipReturnsImage" />
        <div className="tab-container">
          {tabs.map(tab => (
            <button
              key={tab.id}
              className={`tab-button ${activeTab === tab.id ? 'active' : ''}`}
              onClick={() => this.handleTabClick(tab.id)}
            >
              {tab.title}
            </button>
          ))}
        </div>
        <div className="content">
          {activeTab !== null && <p>{tabs.find(tab => tab.id === activeTab).content}</p>}
        </div>
      </div>
    );
  }
}

export default ShipReturnPage;
