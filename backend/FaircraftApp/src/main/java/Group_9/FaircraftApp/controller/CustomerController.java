package Group_9.FaircraftApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Group_9.FaircraftApp.dto.CustomerDTO;
import Group_9.FaircraftApp.model.Customer;
import Group_9.FaircraftApp.repository.CustomerRepository;
import Group_9.FaircraftApp.service.CustomerService;



@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository CustomerRepository;
    @Autowired
	CustomerService userService;

    @PostMapping("/contactformapi")
    public ResponseEntity<String> getContact(@RequestBody CustomerDTO CustomerDTO) {
        try {
            // Check if email already exists
            if (CustomerRepository.existsByEmail(CustomerDTO.getEmail())) {
                return ResponseEntity.badRequest().body("Email address already exists");
            }
            
            // Create a new User entity and save it to the database
            Customer customer = new Customer(CustomerDTO.getName(), CustomerDTO.getEmail(), CustomerDTO.getPhoneNumber(), CustomerDTO.getContactMessage());
            CustomerRepository.save(customer);

            return ResponseEntity.ok("Customer details received successfully");
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while sending the details. Please try again.");
        }
    }
}
