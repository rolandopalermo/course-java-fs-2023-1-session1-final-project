package com.rpconsulting.app.ecommerce.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDto {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal taxAmount;
    private BigDecimal discount;
}
