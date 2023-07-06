package com.rpconsulting.app.ecommerce.dtos;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreationRequestDto {
    private String dni;
    private String name;
    private String email;
    private String phone;
    private String documentType;
    private String paymentType;
    private List<OrderDetailRequestDto> products;
}
