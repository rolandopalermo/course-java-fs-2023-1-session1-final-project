package com.rpconsulting.app.ecommerce.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rpconsulting.app.ecommerce.dtos.ProductCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.ProductCreationResponseDto;
import com.rpconsulting.app.ecommerce.services.ProductsService;

import lombok.RequiredArgsConstructor;

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
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductCreationResponseDto update(@RequestBody ProductCreationRequestDto request) {
        return productsService.create(request);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        productsService.delete(id);
    }
}
