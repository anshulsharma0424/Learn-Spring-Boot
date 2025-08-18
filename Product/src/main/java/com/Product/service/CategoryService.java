package com.Product.service;

import com.Product.dto.CategoryDTO;
import com.Product.entity.Category;
import com.Product.mapper.CategoryMapper;
import com.Product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// In Services -> Creating business logic

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired // optional with 1 constructor
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
       Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    // Get all categories


    // Get category by ID


    // Delete category


}
