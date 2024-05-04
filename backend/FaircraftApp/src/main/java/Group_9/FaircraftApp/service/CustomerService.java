package Group_9.FaircraftApp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group_9.FaircraftApp.exception.ResourceNotFoundException;
import Group_9.FaircraftApp.model.Customer;
import Group_9.FaircraftApp.repository.CustomerRepository;



@Service
public class CustomerService {
	@Autowired
    CustomerRepository userRepository;
	
	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Customer> getUsers() {
		return (List<Customer>) userRepository.findAll();
	}

	public void addUser(Customer newUser) {
		userRepository.save(newUser);
	}
	
	public Optional<Customer> findByID(Long id) {
		 return userRepository.findById(id);
	}
	
	public void deleteUser(Long id) {
		Customer user = userRepository.findById(id)
				  .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.delete(user);
	}
	
	public Customer findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}