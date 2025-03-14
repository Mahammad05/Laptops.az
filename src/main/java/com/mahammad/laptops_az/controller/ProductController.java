package com.mahammad.laptops_az.controller;

import com.mahammad.laptops_az.dto.ProductDto;
import com.mahammad.laptops_az.model.Product;
import com.mahammad.laptops_az.model.response.ServiceResponse;
import com.mahammad.laptops_az.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    // Get All products
    @GetMapping("/products")
    public ServiceResponse<List<Product>> getProducts() {
        List<Product> response = service.getAllProducts();
        return ServiceResponse.success(response);
    }

    // Get Product by ID
    @GetMapping("/products/{id}")
    public ServiceResponse<Product> getProductById(@PathVariable int id) {
        Product response = service.getProductById(id);
        return ServiceResponse.success(response);
    }

    // Add product
    @PostMapping("/products")
    public ServiceResponse<Product> createProduct(@RequestBody ProductDto productDto) {
        Product response = service.addProduct(productDto);
        return ServiceResponse.success(response);
    }
}
