package com.rpconsulting.app.ecommerce.controllers;

import com.rpconsulting.app.ecommerce.dtos.OrderCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.OrderCreationResponseDto;
import com.rpconsulting.app.ecommerce.services.PaymentDocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "api/v1.0/checkout")
@RequiredArgsConstructor
public class PaymentDocumentController {
    private final PaymentDocumentService documentDetailService;

    @PostMapping
    public OrderCreationResponseDto checkout(@RequestBody OrderCreationRequestDto orderDto) {
        log.info(String.valueOf(orderDto));
        return documentDetailService.checkout(orderDto);
    }
}

