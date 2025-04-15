package com.mahammad.laptops_az.service.impl;

import com.mahammad.laptops_az.dto.ProductDto;
import com.mahammad.laptops_az.exception.ApplicationException;
import com.mahammad.laptops_az.exception.ExceptionEnum;
import com.mahammad.laptops_az.model.Category;
import com.mahammad.laptops_az.model.Product;
import com.mahammad.laptops_az.repository.CategoryRepository;
import com.mahammad.laptops_az.repository.ProductRepository;
import com.mahammad.laptops_az.service.IProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new ApplicationException(ExceptionEnum.PRODUCT_NOT_FOUND_EXCEPTION);
        }
        return products;
    }

    // Get product by id
    @Override
    public Product getProductById(int id) {
        log.info("===================== GET PRODUCT BY ID =====================");
        Product product = productRepository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionEnum.PRODUCT_NOT_FOUND_EXCEPTION));
        return product;
    }

    // Add new product
    @Override
    @Transactional
    public Product addProduct(ProductDto productDto) {
        log.info("===================== ADD PRODUCT =====================");

        // Find Category
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ApplicationException(ExceptionEnum.CATEGORY_NOT_FOUND_EXCEPTION));

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
