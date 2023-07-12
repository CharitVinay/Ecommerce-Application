package com.ecommerce.Ecommerce.Application.repository;

import com.ecommerce.Ecommerce.Application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
