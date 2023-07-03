package com.rpconsulting.app.ecommerce.services;

import com.rpconsulting.app.ecommerce.dtos.OrderRequestDto;
import com.rpconsulting.app.ecommerce.dtos.OrderResponseDto;

public interface DocumentDetailService {

    OrderResponseDto checkout(OrderRequestDto request);
}

