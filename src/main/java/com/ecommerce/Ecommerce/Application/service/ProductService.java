package com.ecommerce.Ecommerce.Application.service;

import com.ecommerce.Ecommerce.Application.model.Product;
import com.ecommerce.Ecommerce.Application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
