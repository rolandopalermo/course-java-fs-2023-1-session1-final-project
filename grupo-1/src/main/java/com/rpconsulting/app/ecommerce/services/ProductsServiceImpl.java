package com.rpconsulting.app.ecommerce.services;

import java.util.Optional;

import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import com.rpconsulting.app.ecommerce.dtos.ProductCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationResponseDto;
import com.rpconsulting.app.ecommerce.errors.exceptions.AlreadyExistsException;
import com.rpconsulting.app.ecommerce.errors.exceptions.NotFoundException;
import com.rpconsulting.app.ecommerce.repositories.CategoryRepository;
import com.rpconsulting.app.ecommerce.repositories.ProductRepository;
import com.rpconsulting.app.ecommerce.repositories.entities.Category;
import com.rpconsulting.app.ecommerce.repositories.entities.Product;

import lombok.RequiredArgsConstructor;
import static java.text.MessageFormat.format;


@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	@Override
	public ProductCreationResponseDto create(ProductCreationRequestDto request) {
		Optional<Product> products = productRepository.findFirstByName(request.getName());
    	if (products.isPresent()) {
    		throw new AlreadyExistsException("La producto ingresado : " + request.getName() 
    		+ ", ya existe.");
    	}
    	
    	Product product = productRepository.save(toEntity(request));
    	
        return toResponse(product);
	}
	
	private Category findFirstById(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("El id de la categoria ingresada {0}, no existe", id)));
    }

	@Override
	public ProductCreationResponseDto update(ProductCreationRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	private Product toEntity(ProductCreationRequestDto request) {
		Product product = new Product();
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
		
		product.setCategory(findFirstById(request.getCategoryId()));
		
//		Optional<Category> category = categoryRepository.findById(request.getCategoryId());
//		if (category.isPresent()) {
//			product.setCategory(category.get());
//		}
        return product;
    }
	
    private ProductCreationResponseDto toResponse(Product product) {
    	ProductCreationResponseDto response = new ProductCreationResponseDto();

        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setCategoryId(product.getCategory().getId());
        
        return response;
    }

}
