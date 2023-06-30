package com.rpconsulting.app.ecommerce.services;

import com.rpconsulting.app.ecommerce.dtos.ProductCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationResponseDto;

public interface ProductsService {
	
	ProductCreationResponseDto create(ProductCreationRequestDto request);
	
	ProductCreationResponseDto update(ProductCreationRequestDto request);
	
	void delete(Long id);

}
