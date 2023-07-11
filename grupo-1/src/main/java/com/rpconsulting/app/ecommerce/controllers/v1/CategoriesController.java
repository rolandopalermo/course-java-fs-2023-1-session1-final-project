package com.rpconsulting.app.ecommerce.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rpconsulting.app.ecommerce.dtos.CategoryCreationRequestDto;
import com.rpconsulting.app.ecommerce.dtos.CategoryCreationResponseDto;
import com.rpconsulting.app.ecommerce.services.CategoriesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "api/v1.0/categories")
@RequiredArgsConstructor
public class CategoriesController {

	private final CategoriesService categoriesService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoryCreationResponseDto create(@RequestBody CategoryCreationRequestDto request) {
        return categoriesService.create(request);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryCreationResponseDto update(
    		@PathVariable("id") long id
    		, @RequestBody CategoryCreationRequestDto request) {
        return categoriesService.update(id, request);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        categoriesService.delete(id);
    }
}
