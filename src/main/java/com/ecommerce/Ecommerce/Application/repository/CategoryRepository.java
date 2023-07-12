package com.ecommerce.Ecommerce.Application.repository;

import com.ecommerce.Ecommerce.Application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
