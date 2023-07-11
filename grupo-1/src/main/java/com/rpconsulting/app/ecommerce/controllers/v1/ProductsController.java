package com.rpconsulting.app.ecommerce.controllers.v1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rpconsulting.app.ecommerce.annotations.ProductsListFilter;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationResponseDto;
import com.rpconsulting.app.ecommerce.dtos.ProductFilterDto;
import com.rpconsulting.app.ecommerce.dtos.ProductSumaryDto;
import com.rpconsulting.app.ecommerce.dtos.ProductUpdateRequestDto;
import com.rpconsulting.app.ecommerce.dtos.StockCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.StockCreationResponseDto;
import com.rpconsulting.app.ecommerce.services.ProductsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "api/v1.0/products")
@RequiredArgsConstructor
public class ProductsController {
	
	private final ProductsService productsService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductCreationResponseDto create(@RequestBody ProductCreationRequestDto request) {
        return productsService.create(request);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductCreationResponseDto update(
    		@PathVariable("id") long id
    		, @RequestBody ProductUpdateRequestDto request) {
        return productsService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        productsService.delete(id);
    }
    
    @PutMapping("/{id}/update-stock")
    @ResponseStatus(code = HttpStatus.OK)
    public StockCreationResponseDto updateStock(
    		@PathVariable("id") long id
    		, @RequestBody StockCreationRequestDto request) {
        return productsService.updateStock(id, request);
    }
    
    @ProductsListFilter
    @GetMapping("all")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<ProductSumaryDto> findAllProducts(
    		ProductFilterDto filters,
            Pageable pageable) {
    	log.info("Filters = {}", filters);
        return productsService.findAllProducts(filters, pageable);
    }
    
}
