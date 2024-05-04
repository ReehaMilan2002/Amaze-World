package Group_9.FaircraftApp.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import Group_9.FaircraftApp.model.WishlistItems;
import Group_9.FaircraftApp.model.products;
import Group_9.FaircraftApp.repository.productRepository;
import Group_9.FaircraftApp.repository.wishlist_repository;

//WishlistController.java
@RestController
@RequestMapping("/api/wishlist")


public class wishlist_controller {

 @Autowired
 private wishlist_repository wishlistRepository;
 
 @GetMapping
 public List<WishlistItems> getWishlistItems() {
     return wishlistRepository.findAll();
 }

 @Autowired
 private productRepository productRepository;

 @PostMapping("/add/{productId}")
 public ResponseEntity<String> addToWishlist(@PathVariable Integer productId) {
     if (productId != null) {
         Optional<products> optionalProduct = productRepository.findById(productId);
         if (optionalProduct.isPresent()) {
             products product = optionalProduct.get();
             Optional<WishlistItems> existingItem = wishlistRepository.findByProduct(product);
             if (existingItem.isPresent()) {
                 return ResponseEntity.badRequest().body("Product is already in the wishlist");
             }
             
             WishlistItems wishlistItem = new WishlistItems();
             wishlistItem.setProduct(product);
             wishlistRepository.save(wishlistItem);
             return ResponseEntity.ok("Product added to wishlist successfully");
         } else {
             return ResponseEntity.notFound().build();
         }
     } else {
         return ResponseEntity.badRequest().body("Product ID cannot be null");
     }
 }
 
 @DeleteMapping("/remove/{productId}")
 public ResponseEntity<String> removeFromWishlist(@PathVariable Integer productId) {
     Optional<WishlistItems> optionalWishlistItem = wishlistRepository.findByProductId(productId);
     if (optionalWishlistItem.isPresent()) {
         WishlistItems wishlistItem = optionalWishlistItem.get();
         if (wishlistItem != null) {
             wishlistRepository.delete(wishlistItem);
             return ResponseEntity.ok("Product removed from wishlist successfully");
         } else {
             return ResponseEntity.badRequest().body("Wishlist item is null");
         }
     } else {
         return ResponseEntity.notFound().build();
     }
 }





}