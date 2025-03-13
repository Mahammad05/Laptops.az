package com.mahammad.laptops_az.repository;

import com.mahammad.laptops_az.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Get by category_id
    List<Product> findByCategoryId(int categoryId);
}
