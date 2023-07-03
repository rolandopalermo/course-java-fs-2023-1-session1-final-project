package com.rpconsulting.app.ecommerce.services;

import com.rpconsulting.app.ecommerce.dtos.OrderRequestDto;
import com.rpconsulting.app.ecommerce.dtos.OrderResponseDto;
import com.rpconsulting.app.ecommerce.dtos.ProductRequestDto;
import com.rpconsulting.app.ecommerce.errors.exceptions.NotFoundException;
import com.rpconsulting.app.ecommerce.repositories.CustomerRepository;
import com.rpconsulting.app.ecommerce.repositories.DocumentDetailRepository;
import com.rpconsulting.app.ecommerce.repositories.PaymentDocumentRepository;
import com.rpconsulting.app.ecommerce.repositories.entities.Customer;
import com.rpconsulting.app.ecommerce.repositories.entities.PaymentDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static java.text.MessageFormat.format;


@Service
@RequiredArgsConstructor
public class DocumentDetailServiceImpl implements DocumentDetailService {

    private final CustomerRepository customerRepository;
    private final PaymentDocumentRepository paymentDocumentRepository;
    private final DocumentDetailRepository documentDetailRepository;

    @Override
    @Transactional
    public OrderResponseDto checkout(OrderRequestDto request) {
        Optional<Customer> existingCustomer = customerRepository.findById(request.getCustomerId());
        PaymentDocument order = new PaymentDocument();

        if (!existingCustomer.isPresent()) {
            throw new NotFoundException(
                    format("El usuario con id {0} no existe", request.getCustomerId())
            );
        }

        order.setCustomer(existingCustomer.get());
        order.setDocumentType(request.getDocumentType());
        order.setPaymentType(request.getPaymentType());
        order.setTotal(getTotal(request));
        order.setDiscount(getTotalDiscount(request));
        order.setTaxAmount(getTaxes(request));
        order.setCreatedAt(LocalDateTime.now());
        paymentDocumentRepository.save(order);
        return toResponse(order);
    }

    private BigDecimal getTotalDiscount(OrderRequestDto request) {
        return request.getProducts().stream()
                .map(ProductRequestDto::getDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal getTaxes(OrderRequestDto request) {
        return request.getProducts().stream()
                .map(ProductRequestDto::getTaxAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal getTotal(OrderRequestDto request) {
        return request.getProducts().stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private OrderResponseDto toResponse(PaymentDocument order) {
        OrderResponseDto response = new OrderResponseDto();
        response.setId(order.getId());
        response.setCustomerId(order.getCustomer().getId());
        response.setCustomerName(order.getCustomer().getName());
        response.setCustomerEmail(order.getCustomer().getEmail());
        response.setCustomerPhone(order.getCustomer().getPhone());
        response.setDocumentType(order.getDocumentType());
        response.setPaymentType(order.getPaymentType());
        response.setTotal(order.getTotal());
        response.setTaxAmount(order.getTaxAmount());
        response.setDiscount(order.getDiscount());
        
        return response;
    }

 
}
