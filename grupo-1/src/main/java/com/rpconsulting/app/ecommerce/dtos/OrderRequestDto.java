package com.rpconsulting.app.ecommerce.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDto {
    private String dni;
    private String name;
    private String email;
    private String phone;
    private String documentType;
    private String paymentType;
    private List<ProductRequestDto> products;
}
