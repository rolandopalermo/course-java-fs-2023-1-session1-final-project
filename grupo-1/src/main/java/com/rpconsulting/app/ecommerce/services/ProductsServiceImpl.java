package com.rpconsulting.app.ecommerce.services;

import static java.text.MessageFormat.format;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpconsulting.app.ecommerce.dtos.ProductCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationResponseDto;
import com.rpconsulting.app.ecommerce.dtos.ProductFilterDto;
import com.rpconsulting.app.ecommerce.dtos.ProductSumaryDto;
import com.rpconsulting.app.ecommerce.dtos.ProductUpdateRequestDto;
import com.rpconsulting.app.ecommerce.dtos.StockCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.StockCreationResponseDto;
import com.rpconsulting.app.ecommerce.errors.exceptions.AlreadyExistsException;
import com.rpconsulting.app.ecommerce.errors.exceptions.NotFoundException;
import com.rpconsulting.app.ecommerce.projections.ProductFilterProjection;
import com.rpconsulting.app.ecommerce.repositories.CategoryRepository;
import com.rpconsulting.app.ecommerce.repositories.ProductRepository;
import com.rpconsulting.app.ecommerce.repositories.entities.Category;
import com.rpconsulting.app.ecommerce.repositories.entities.Product;
import com.rpconsulting.app.ecommerce.repositories.entities.Stock;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final StockService stockService;
	
	@Override
	@Transactional
	public ProductCreationResponseDto create(ProductCreationRequestDto request) {
		Optional<Product> products = productRepository.findFirstByName(request.getName());
    	if (products.isPresent()) {
    		throw new AlreadyExistsException(format("La producto ingresado : {0}, ya existe.", request.getName()));
    	}
    	
    	Product pro = toEntity(request);
    	pro.setCategory(findFirstCategoryById(request.getCategoryId()));
    	
    	Product product = productRepository.save(pro);
    	
    	stockService.updateStock(product, new BigDecimal(0.0));
    	
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

	@Override
	public StockCreationResponseDto updateStock(long id, StockCreationRequestDto request) {
		Product product = findFirstProductById(id);
		return toRenponse(stockService.updateStock(product, request.getQuantity()));
	}
	
	private StockCreationResponseDto toRenponse(Stock stock) {
		StockCreationResponseDto sDto = new StockCreationResponseDto();
		sDto.setCurrentStock(stock.getStock());
		sDto.setProductId(stock.getProduct().getId());
		return sDto;
	}

	@Override
	public Page<ProductSumaryDto> findAllProducts(ProductFilterDto filters, Pageable pageable) {
		Page<ProductFilterProjection> page = productRepository.findListProduct(
				filters.getNameProduct()
				, filters.getPriceMin()
				, filters.getPriceMax()
				, filters.getNameCategory(), pageable);
        return new PageImpl<>(
                page.stream().map(this::toDto).collect(Collectors.toList()),
                page.getPageable(),
                page.getTotalElements()
        );
	}
	
	private ProductSumaryDto toDto(ProductFilterProjection projection) {
		ProductSumaryDto dto = new ProductSumaryDto();
		dto.setCategoryProduct(projection.getCategory());
		dto.setIdProduct(projection.getId());
		dto.setNameProduct(projection.getProduct());
		dto.setPriceProduct(projection.getPrice());
		dto.setStockProduct(projection.getStock());
        return dto;
    }

}
