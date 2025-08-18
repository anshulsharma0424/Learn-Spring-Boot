package com.Product.controller;

import com.Product.dto.CategoryDTO;
import com.Product.dto.ProductDTO;
import com.Product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    // Create product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    // Get all products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Update product
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.updateProduct(id, productDTO), HttpStatus.OK);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
