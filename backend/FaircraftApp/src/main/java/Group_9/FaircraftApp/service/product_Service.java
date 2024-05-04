package Group_9.FaircraftApp.service;
import Group_9.FaircraftApp.model.products;

import java.util.List;


public interface product_Service {
	 List<products> getAllProducts();		
	 
	 
	 //karma change
	 List<products> searchProduct(String query); 
	 
}
