package com.Product.service;

import com.Product.dto.CategoryDTO;
import com.Product.entity.Category;
import com.Product.exception.CategoryAlreadyExistsException;
import com.Product.mapper.CategoryMapper;
import com.Product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        // Check if the category already exists?
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if (optionalCategory.isPresent()) {
            throw new CategoryAlreadyExistsException("Category " + categoryDTO.getName() + " already exists");
        }

       Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    // Get all categories
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    // Get category by ID
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }

    // Delete category
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Category with id: "+ id + " has been deleted successfully";
    }

}
