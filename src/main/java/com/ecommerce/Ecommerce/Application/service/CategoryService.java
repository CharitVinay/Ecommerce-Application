package com.ecommerce.Ecommerce.Application.service;

import com.ecommerce.Ecommerce.Application.model.Category;
import com.ecommerce.Ecommerce.Application.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategory()
    {
        return categoryRepository.findAll();
    }

    public void removeCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategoryById(int id)
    {
        return categoryRepository.findById(id);
    }
}
