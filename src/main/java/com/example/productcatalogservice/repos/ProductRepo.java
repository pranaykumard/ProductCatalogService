package com.example.productcatalogservice.repos;

import com.example.productcatalogservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findProductByAmountBetween(Double low, Double high);

    List<Product> findProductByIsPrimeSpecificTrue();

    @Query("SELECT p.description from Product p where p.id = ?1")
    String findProductDescriptionFromProductId(Long id);

    @Query("select c.name from Category c join Product p on p.category.id=c.id where p.id=:id")
    String findCategoryNameFromProductId(Long id);


}
