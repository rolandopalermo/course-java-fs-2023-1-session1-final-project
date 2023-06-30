package com.rpconsulting.app.ecommerce.services;

import java.util.Optional;

import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import com.rpconsulting.app.ecommerce.dtos.ProductCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationResponseDto;
import com.rpconsulting.app.ecommerce.dtos.ProductUpdateRequestDto;
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
    	
    	Product pro = toEntity(request);
    	pro.setCategory(findFirstCategoryById(request.getCategoryId()));
    	
    	Product product = productRepository.save(pro);
    	
        return toResponse(product);
	}
	
	private Category findFirstCategoryById(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("El id de la categoria ingresada {0}, no existe", id)));
    }
	
	private Product findFirstProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(format("El id del producto {0}, no existe", id)));
    }

	@Override
	public ProductCreationResponseDto update(long id, ProductUpdateRequestDto request) {
		Product pro = findFirstProductById(id);
		pro.setName(request.getName());
		pro.setDescription(request.getDescription());
		pro.setPrice(request.getPrice());
		pro.setCategory(findFirstCategoryById(request.getCategoryId()));
		
		return toResponse(productRepository.save(pro));
	}

	@Override
	public void delete(Long id) {
		productRepository.findById(id).ifPresent(productRepository::delete);
	}
	
	private Product toEntity(ProductCreationRequestDto request) {
		Product product = new Product();
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setPrice(request.getPrice());
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
