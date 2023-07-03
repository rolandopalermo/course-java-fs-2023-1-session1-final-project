package com.rpconsulting.app.ecommerce.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDto {
    private Long id;
    private String product;
    private String description;
    private String category;
    private Integer quantity;
    private BigDecimal price;
}