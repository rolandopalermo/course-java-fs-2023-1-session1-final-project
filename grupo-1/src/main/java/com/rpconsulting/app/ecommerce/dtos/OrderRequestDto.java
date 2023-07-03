package com.rpconsulting.app.ecommerce.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDto {
    private Long customerId;
    private String documentType;
    private String paymentType;
    private List<ProductRequestDto> products;
}
