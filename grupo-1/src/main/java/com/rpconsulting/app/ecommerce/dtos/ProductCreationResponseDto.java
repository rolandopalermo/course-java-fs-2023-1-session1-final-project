package com.rpconsulting.app.ecommerce.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductCreationResponseDto {
	private Long id;
	private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
}
