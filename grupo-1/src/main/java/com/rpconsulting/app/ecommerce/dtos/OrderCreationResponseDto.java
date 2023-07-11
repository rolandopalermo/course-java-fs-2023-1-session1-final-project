package com.rpconsulting.app.ecommerce.dtos;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderCreationResponseDto {
    private Long id;
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String documentType;
    private String paymentType;
    private BigDecimal total;
    private BigDecimal taxAmount;
    private BigDecimal discount;
}
