package com.rpconsulting.app.ecommerce.services;

import com.rpconsulting.app.ecommerce.dtos.product.PaymentMethodDto;
import com.rpconsulting.app.ecommerce.dtos.product.SelectedProductDto;
import com.rpconsulting.app.ecommerce.dtos.product.SelectedProductResponseDto;
import com.rpconsulting.app.ecommerce.repositories.entities.DocumentDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DocumentDetailService {
    SelectedProductResponseDto addToCart(SelectedProductDto selectedProduct);
    void removeFromCart(Long productId);
    void clearCart();
    Page<DocumentDetail> getCartProducts(Pageable pageable);
    void checkout(PaymentMethodDto paymentMethod);
}

