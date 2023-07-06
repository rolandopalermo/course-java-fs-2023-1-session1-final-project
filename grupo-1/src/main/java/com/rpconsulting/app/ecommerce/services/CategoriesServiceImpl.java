package com.rpconsulting.app.ecommerce.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rpconsulting.app.ecommerce.dtos.CategoryCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.CategoryCreationResponseDto;
import com.rpconsulting.app.ecommerce.errors.exceptions.AlreadyExistsException;
import com.rpconsulting.app.ecommerce.errors.exceptions.NotFoundException;
import com.rpconsulting.app.ecommerce.repositories.CategoryRepository;
import com.rpconsulting.app.ecommerce.repositories.entities.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
	
	private final CategoryRepository categoryRepository;

	@Override
	public CategoryCreationResponseDto create(CategoryCreationRequestDto request) {
		Optional<Category> categories = categoryRepository.findFirstByName(request.getName());
    	
    	if (categories.isPresent()) {
    		throw new AlreadyExistsException("La categoria: " + request.getName() 
    		+ ", ya existe.");
    	}
    	
    	Category category = categoryRepository.save(toEntity(request));
    	
        return toResponse(category);
	}

	@Override
	public CategoryCreationResponseDto update(long id, CategoryCreationRequestDto request) {
		Optional<Category> categories = categoryRepository.findById(id);
		if (categories.isPresent()) {
			categories.get().setName(request.getName());
			categories.get().setDescription(request.getDescription());
			return toResponse(categoryRepository.save(categories.get()));
		} else {
			throw new NotFoundException("La categoria ingresada: " + request.getName() 
    		+ " no existe.");
		}
	}

	@Override
	public void delete(long id) {
		categoryRepository.findById(id).ifPresent(categoryRepository::delete);
	}
	
	private Category toEntity(CategoryCreationRequestDto request) {
		Category category = new Category();

		category.setName(request.getName());
		category.setDescription(request.getDescription());

        return category;
    }
	
    private CategoryCreationResponseDto toResponse(Category category) {
    	CategoryCreationResponseDto response = new CategoryCreationResponseDto();

        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        
        return response;
    }

}
