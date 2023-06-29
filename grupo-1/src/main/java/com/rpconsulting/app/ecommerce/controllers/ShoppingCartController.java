package com.rpconsulting.app.ecommerce.controllers;

import com.rpconsulting.app.ecommerce.dtos.product.PaymentMethodDto;
import com.rpconsulting.app.ecommerce.dtos.product.SelectedProductDto;
import com.rpconsulting.app.ecommerce.dtos.product.SelectedProductResponseDto;
import com.rpconsulting.app.ecommerce.repositories.entities.DocumentDetail;
import com.rpconsulting.app.ecommerce.services.DocumentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1.0/cart")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final DocumentDetailService shoppingCartService;

    @PostMapping("/add")
    public SelectedProductResponseDto addToCart(@RequestBody SelectedProductDto selectedProduct) {
        return shoppingCartService.addToCart(selectedProduct);
    }

    @PostMapping("/remove/{productId}")
    public void removeFromCart(@PathVariable Long productId) {
        shoppingCartService.removeFromCart(productId);
    }

    @PostMapping("/clear")
    public void clearCart() {
        shoppingCartService.clearCart();
    }

    @GetMapping("/products")
    public Page<DocumentDetail> getCartProducts(
            Pageable pageable
    ) {
        return shoppingCartService.getCartProducts(pageable);
    }

    @PostMapping("/checkout")
    public void checkout(@RequestBody PaymentMethodDto paymentMethod) {
        shoppingCartService.checkout(paymentMethod);
    }
}

