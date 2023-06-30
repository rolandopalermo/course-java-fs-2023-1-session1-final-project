package com.rpconsulting.app.ecommerce.services;

import com.rpconsulting.app.ecommerce.dtos.ProductCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationResponseDto;
import com.rpconsulting.app.ecommerce.dtos.ProductUpdateRequestDto;

public interface ProductsService {
	
	ProductCreationResponseDto create(ProductCreationRequestDto request);
	
	ProductCreationResponseDto update(long id, ProductUpdateRequestDto request);
	
	void delete(Long id);

}
