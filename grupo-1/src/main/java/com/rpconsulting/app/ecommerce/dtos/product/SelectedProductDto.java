package com.rpconsulting.app.ecommerce.dtos.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SelectedProductDto {
    private Long productId;
    private BigDecimal quantity;
}
