package com.rpconsulting.app.ecommerce.services;

import com.rpconsulting.app.ecommerce.dtos.CategoryCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.CategoryCreationResponseDto;

public interface CategoriesService {
	
	CategoryCreationResponseDto create(CategoryCreationRequestDto request);
	
	void delete(long id);

	CategoryCreationResponseDto update(long id, CategoryCreationRequestDto request);
	
}
