package com.rpconsulting.app.ecommerce.dtos.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SelectedProductResponseDto {
    private Long id;
    private String productName;
    private BigDecimal quantity;
    private BigDecimal price;
}
