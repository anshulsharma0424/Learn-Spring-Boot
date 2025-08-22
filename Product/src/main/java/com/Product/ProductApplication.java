package com.Product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
        info = @Info(
                title = "Product service REST API Documentation",
                description = "Product service REST API",
                version = "v1",
                contact = @Contact(
                        name = "Developer",
                        email = "developer@companyDeveloper.com"
                )
        )
)


@SpringBootApplication
public class ProductApplication {
	public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
	}
}
