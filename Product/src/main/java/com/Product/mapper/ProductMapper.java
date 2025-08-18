package com.Product.mapper;

import com.Product.dto.ProductDTO;
import com.Product.entity.Category;
import com.Product.entity.Product;

public class ProductMapper {

    // ProductEntity to ProductDTO conversion
    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    // ProductDTO to ProductEntity conversion
    public static Product toProductEntity(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return product;
    }
}
