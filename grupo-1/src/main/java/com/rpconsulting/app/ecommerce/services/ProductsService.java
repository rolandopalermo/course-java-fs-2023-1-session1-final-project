package com.rpconsulting.app.ecommerce.services;

import java.math.BigDecimal;

import com.rpconsulting.app.ecommerce.repositories.entities.Product;
import com.rpconsulting.app.ecommerce.repositories.entities.Stock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rpconsulting.app.ecommerce.dtos.ProductCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationResponseDto;
import com.rpconsulting.app.ecommerce.dtos.ProductUpdateRequestDto;
import com.rpconsulting.app.ecommerce.dtos.StockCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.StockCreationResponseDto;
import com.rpconsulting.app.ecommerce.dtos.ProductSumaryDto;
import com.rpconsulting.app.ecommerce.dtos.ProductFilterDto;

public interface ProductsService {
	
	ProductCreationResponseDto create(ProductCreationRequestDto request);
	
	ProductCreationResponseDto update(long id, ProductUpdateRequestDto request);
	
	void delete(Long id);

	StockCreationResponseDto updateStock(long id, StockCreationRequestDto request);

	Stock updateStock(Product producto, BigDecimal quantity, int action);
	
	Page<ProductSumaryDto> findAllProducts(ProductFilterDto filters, Pageable pageable);

}
