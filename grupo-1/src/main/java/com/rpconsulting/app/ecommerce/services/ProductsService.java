package com.rpconsulting.app.ecommerce.services;

import java.math.BigDecimal;

import com.rpconsulting.app.ecommerce.dtos.ProductCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationResponseDto;
import com.rpconsulting.app.ecommerce.dtos.ProductUpdateRequestDto;
import com.rpconsulting.app.ecommerce.dtos.StockCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.StockCreationResponseDto;

public interface ProductsService {
	
	ProductCreationResponseDto create(ProductCreationRequestDto request);
	
	ProductCreationResponseDto update(long id, ProductUpdateRequestDto request);
	
	void delete(Long id);

	StockCreationResponseDto updateStock(long id, StockCreationRequestDto request);

}
