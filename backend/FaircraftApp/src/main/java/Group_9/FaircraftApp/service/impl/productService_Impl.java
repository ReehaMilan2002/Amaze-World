package Group_9.FaircraftApp.service.impl;


import Group_9.FaircraftApp.model.products;
import Group_9.FaircraftApp.repository.productRepository;
import Group_9.FaircraftApp.service.product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService_Impl implements product_Service {
	
    private final productRepository repository;

    @Autowired
    public productService_Impl(productRepository repository) {
    	super();
        this.repository = repository;
    }

    @Override
    public List<products> getAllProducts() {
        return repository.findAll();
    }
    
    //karma change
	@Override
	public  List<products> searchProduct(String query){
		
	
	List<products> products= repository.searchProductByColor(query);
	
	return products;
	
	}
	
	
}
