package Group_9.FaircraftApp.repository;

import Group_9.FaircraftApp.model.products;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface productRepository extends JpaRepository<products, Integer> {
    
//    @Query("SELECT p FROM products p WHERE "
//            + "p.productName LIKE CONCAT('%', :query, '%') OR "
//            + "p.productDescription LIKE CONCAT('%', :query, '%')")
//    List<products> searchProduct(@Param("query") String query);
    @Query("SELECT p FROM products p WHERE p.productColour LIKE CONCAT('%', :color, '%')")
    List<products> searchProductByColor(@Param("color") String color);
}
