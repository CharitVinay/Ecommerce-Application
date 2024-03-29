package com.ecommerce.Ecommerce.Application.service;

import com.ecommerce.Ecommerce.Application.model.Product;
import com.ecommerce.Ecommerce.Application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProductById(int id)
    {
        productRepository.deleteById(id);
    }

//    public Optional<Product> getProductById(int id)
//    {
//        return productRepository.findById(id);
//    }

    public Product getProductById(int id)
    {
        Optional<Product> res = productRepository.findById(id);
        Product product = null;
        if(res.isPresent())
        {
            product = res.get();
        }

        return product;

    }

    public List<Product> getAllProductsByCategoryId(int id)
    {
        return productRepository.findAllByCategory_Id(id);
    }
}
