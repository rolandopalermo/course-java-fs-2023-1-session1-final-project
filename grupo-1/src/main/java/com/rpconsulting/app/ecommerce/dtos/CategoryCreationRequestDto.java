package com.rpconsulting.app.ecommerce.dtos;

import lombok.Data;

@Data
public class CategoryCreationRequestDto {
	private String name;
    private String description;
}
