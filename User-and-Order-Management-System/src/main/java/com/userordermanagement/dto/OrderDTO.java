package com.userordermanagement.dto;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String product;
    private int quantity;
    private Double price;
    private LocalDateTime orderDate;
    private Long userId;
}
