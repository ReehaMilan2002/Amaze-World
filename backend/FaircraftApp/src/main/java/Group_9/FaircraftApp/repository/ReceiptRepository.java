package Group_9.FaircraftApp.repository;

import Group_9.FaircraftApp.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    // You can add custom query methods if needed
}
