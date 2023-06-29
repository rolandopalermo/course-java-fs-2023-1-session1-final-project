package com.rpconsulting.app.ecommerce.services;

import com.rpconsulting.app.ecommerce.dtos.product.PaymentMethodDto;
import com.rpconsulting.app.ecommerce.dtos.product.SelectedProductDto;
import com.rpconsulting.app.ecommerce.dtos.product.SelectedProductResponseDto;
import com.rpconsulting.app.ecommerce.repositories.DocumentDetailRepository;
import com.rpconsulting.app.ecommerce.repositories.entities.DocumentDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DocumentDetailServiceImpl implements DocumentDetailService {

    private final DocumentDetailRepository documentDetailRepository;

    @Override
    public SelectedProductResponseDto addToCart(SelectedProductDto selectedProduct) {
        DocumentDetail documentDetail = documentDetailRepository.save(toEntity(selectedProduct));
        return toCreationResponse(documentDetail);
    }

    private DocumentDetail toEntity(SelectedProductDto request) {
        DocumentDetail documentDetail = new DocumentDetail();
        documentDetail.setQuantity(request.getQuantity());
        return documentDetail;
    }

    private SelectedProductResponseDto toCreationResponse(DocumentDetail documentDetail) {
        SelectedProductResponseDto response = new SelectedProductResponseDto();
        response.setId(documentDetail.getId());
        return response;
    }

    @Override
    public void removeFromCart(Long productId) {

    }

    @Override
    public void clearCart() {
        this.documentDetailRepository.deleteAll();
    }

    @Override
    public Page<DocumentDetail> getCartProducts(Pageable pageable) {
        return this.documentDetailRepository.findAllDetails(pageable);
    }

    @Override
    public void checkout(PaymentMethodDto paymentMethod) {

    }

}
