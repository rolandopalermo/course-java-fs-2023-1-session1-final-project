package com.rpconsulting.app.ecommerce.services;

import com.rpconsulting.app.ecommerce.dtos.OrderCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.OrderCreationResponseDto;

public interface PaymentDocumentService {

    OrderCreationResponseDto checkout(OrderCreationRequestDto request);
}

