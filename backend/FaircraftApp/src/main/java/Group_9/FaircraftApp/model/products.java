package Group_9.FaircraftApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;
    private String productImage;
    private float productPrice;
    private String productColour;
    private String productDescription;
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
    
    
    //karma addition
    public String getProductDesc() {
       return productDescription;
    }
    
    //karma addition
    public void setProductDesc(String productDescription) {
        this.productDescription = productDescription;
    }
    
    public String getProductColour() {
        return productColour;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
    }
    
    
    
    

	
}
