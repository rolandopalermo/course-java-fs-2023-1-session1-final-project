package com.rpconsulting.app.ecommerce.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductUpdateRequestDto {
	private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
}
