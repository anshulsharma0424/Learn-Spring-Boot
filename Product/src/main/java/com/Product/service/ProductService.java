package com.Product.service;

import com.Product.dto.ProductDTO;
import com.Product.entity.Category;
import com.Product.entity.Product;
import com.Product.exception.CategoryNotFoundException;
import com.Product.mapper.ProductMapper;
import com.Product.repository.CategoryRepository;
import com.Product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

//    @Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    // Create Product
    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("Category with id:" + productDTO.getCategoryId() + " not found"));

        // DTO to Entity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        // Entity to DTO
        return ProductMapper.toProductDTO(product);
    }

    // Get all products
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    // Get product by productID
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    // Update product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        productRepository.save(product);

        return ProductMapper.toProductDTO(product);
    }

    // Delete product
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product with id: " + id + " has been deleted successfully";
    }

}
