// wishlistRepository.java
package Group_9.FaircraftApp.repository;

import Group_9.FaircraftApp.model.WishlistItems;
import Group_9.FaircraftApp.model.products;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface wishlist_repository extends JpaRepository<WishlistItems, Long> {
	
    Optional<WishlistItems> findByProduct(products product);
    Optional<WishlistItems> findById(Integer id);
    @Query("SELECT w FROM WishlistItems w WHERE w.product.id = :productId")
    Optional<WishlistItems> findByProductId(@Param("productId") Integer productId);
	
	
	
}