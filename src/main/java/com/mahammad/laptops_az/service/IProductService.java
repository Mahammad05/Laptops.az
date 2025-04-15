package com.mahammad.laptops_az.service;

import com.mahammad.laptops_az.dto.ProductDto;
import com.mahammad.laptops_az.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    Product getProductById(int id);

    Product addProduct(ProductDto productDto);
}
