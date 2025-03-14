package com.mahammad.laptops_az.service;

import com.mahammad.laptops_az.dto.ProductDto;
import com.mahammad.laptops_az.exception.CategoryNotFoundException;
import com.mahammad.laptops_az.exception.ProductNotFoundException;
import com.mahammad.laptops_az.model.Category;
import com.mahammad.laptops_az.model.Product;
import com.mahammad.laptops_az.repository.CategoryRepository;
import com.mahammad.laptops_az.repository.ProductRepository;
import com.mahammad.laptops_az.service.impl.IProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    // Get all products
    @Override
    public List<Product> getAllProducts() {
        log.info("===================== GET ALL PRODUCTS =====================");
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No products found");
        }
        return products;
    }

    // Get product by id
    @Override
    public Product getProductById(int id) {
        log.info("===================== GET PRODUCT BY ID =====================");
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
        return product;
    }

    // Add new product
    @Override
    @Transactional
    public Product addProduct(ProductDto productDto) {
        log.info("===================== ADD PRODUCT =====================");

        // Find Category
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + productDto.getCategoryId()));

        // Build product
        Product product = Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .category(category)
                .build();

        // Save product
        return productRepository.save(product);
    }

}
