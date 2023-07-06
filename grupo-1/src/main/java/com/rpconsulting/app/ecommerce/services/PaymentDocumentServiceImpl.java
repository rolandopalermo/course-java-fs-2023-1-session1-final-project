package com.rpconsulting.app.ecommerce.services;

import com.rpconsulting.app.ecommerce.dtos.OrderCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.OrderCreationResponseDto;
import com.rpconsulting.app.ecommerce.dtos.OrderDetailRequestDto;
import com.rpconsulting.app.ecommerce.errors.exceptions.NotFoundException;
import com.rpconsulting.app.ecommerce.repositories.CustomerRepository;
import com.rpconsulting.app.ecommerce.repositories.DocumentDetailRepository;
import com.rpconsulting.app.ecommerce.repositories.PaymentDocumentRepository;
import com.rpconsulting.app.ecommerce.repositories.ProductRepository;
import com.rpconsulting.app.ecommerce.repositories.entities.Customer;
import com.rpconsulting.app.ecommerce.repositories.entities.DocumentDetail;
import com.rpconsulting.app.ecommerce.repositories.entities.PaymentDocument;
import com.rpconsulting.app.ecommerce.repositories.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;


@Service
@RequiredArgsConstructor
public class PaymentDocumentServiceImpl implements PaymentDocumentService {

    private final CustomerRepository customerRepository;
    private final PaymentDocumentRepository paymentDocumentRepository;
    private final DocumentDetailRepository documentDetailRepository;
    private final ProductRepository productRepository;
    private final ProductsService productsService;

    @Override
    @Transactional
    public OrderCreationResponseDto checkout(OrderCreationRequestDto request) {
        Optional<Customer> existingCustomer = customerRepository.findByDni(request.getDni());
        Customer customer = existingCustomer
                .orElseGet(() -> customerRepository.save(toCustomerEntity(request)));

        PaymentDocument paymentDocument = paymentDocumentRepository.save(toPaymentDocumentEntity(request, customer));
        List<DocumentDetail> details = request
                .getProducts()
                .stream()
                .map(detail -> toDocumentDetailEntity(paymentDocument, detail))
                .collect(Collectors.toList());

        documentDetailRepository.saveAll(details);
        // update stock
        details.forEach(detail -> productsService.updateStock(detail.getProduct(), BigDecimal.valueOf(detail.getQuantity()), 1));
        return toResponse(paymentDocument);
    }

    private BigDecimal getTotalDiscount(OrderCreationRequestDto request) {
        return request.getProducts().stream()
                .map(OrderDetailRequestDto::getDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal getTaxes(OrderCreationRequestDto request) {
        return request.getProducts().stream()
                .map(OrderDetailRequestDto::getTaxAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal getTotal(OrderCreationRequestDto request) {
        return request.getProducts().stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private OrderCreationResponseDto toResponse(PaymentDocument order) {
        OrderCreationResponseDto response = new OrderCreationResponseDto();
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

    private PaymentDocument toPaymentDocumentEntity(OrderCreationRequestDto request, Customer customer) {
        PaymentDocument paymentDocument = new PaymentDocument();
        paymentDocument.setCustomer(customer);
        paymentDocument.setDocumentType(request.getDocumentType());
        paymentDocument.setPaymentType(request.getPaymentType());
        paymentDocument.setTotal(getTotal(request));
        paymentDocument.setDiscount(getTotalDiscount(request));
        paymentDocument.setTaxAmount(getTaxes(request));
        paymentDocument.setCreatedAt(LocalDateTime.now());

        return paymentDocument;
    }

    private Customer toCustomerEntity(OrderCreationRequestDto request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setDni(request.getDni());

        return customer;
    }

    private DocumentDetail toDocumentDetailEntity(PaymentDocument paymentDocument, OrderDetailRequestDto detail) {
        Product product = findById(detail.getId());
        DocumentDetail documentDetail = new DocumentDetail();
        documentDetail.setName(product.getName());
        documentDetail.setPaymentDocument(paymentDocument);
        documentDetail.setPrice(detail.getPrice());
        documentDetail.setQuantity(detail.getQuantity());
        documentDetail.setProduct(product);
        return documentDetail;
    }

    private Product findById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("El id del producto {0}, no existe", id)));
    }

 
}
