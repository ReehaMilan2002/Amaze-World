package Group_9.FaircraftApp.repository;






import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Group_9.FaircraftApp.model.Customer;
import jakarta.persistence.Table;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // Method to find a user by email
    Customer findByEmail(String email);

    // Method to check if a user with a specific email exists
    boolean existsByEmail(String email);
}