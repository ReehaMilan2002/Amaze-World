package Group_9.FaircraftApp.controller;
import Group_9.FaircraftApp.model.products;
import Group_9.FaircraftApp.service.product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController

public class products_controller {
	
	 private final product_Service productService;

	    @Autowired
	    public products_controller(product_Service productService) {
	        this.productService = productService;
	    }
	    
	        
@GetMapping("/shop_page")

public List<products> getproducts(){
	   return productService.getAllProducts();
}

// Mapping for searching products by color
@GetMapping("/shop_page/search")
public List<products> searchProductByColor(@RequestParam("color") String color) {
    // Call the service method to search for products by color
    return productService.searchProduct(color);
}


}