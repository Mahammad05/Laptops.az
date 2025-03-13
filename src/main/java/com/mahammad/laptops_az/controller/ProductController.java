package com.mahammad.laptops_az.controller;

import com.mahammad.laptops_az.model.Product;
import com.mahammad.laptops_az.model.response.ServiceResponse;
import com.mahammad.laptops_az.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    // Get All products
    @GetMapping("/products")
    public ServiceResponse<List<Product>> getProducts() {
        List<Product> products = service.getAllProducts();
        return ServiceResponse.success(products);
    }
}
