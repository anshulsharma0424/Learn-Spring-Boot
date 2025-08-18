package com.Product.mapper;

import com.Product.dto.CategoryDTO;
import com.Product.entity.Category;

public class CategoryMapper {

    // CategoryDTO to CategoryEntity conversion
    public static Category toCategoryEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }

    // CategoryEntity to CategoryDTO conversion
    public static CategoryDTO toCategoryDTO(Category category) {
        if (category == null) return null;

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());

        return categoryDTO;
    }
}
