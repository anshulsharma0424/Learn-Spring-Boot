package com.Product.service;

import com.Product.dto.ProductDTO;
import com.Product.entity.Category;
import com.Product.entity.Product;
import com.Product.mapper.ProductMapper;
import com.Product.repository.CategoryRepository;
import com.Product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

//    @Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    // Create Product
    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category Not Found"));

        // ProductDTO to ProductEntity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);

        // ProductEntity to ProductDTO
        return ProductMapper.toProductDTO(product);
    }
}
