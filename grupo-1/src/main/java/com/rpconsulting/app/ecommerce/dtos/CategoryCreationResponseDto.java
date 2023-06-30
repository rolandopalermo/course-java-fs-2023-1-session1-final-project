package com.rpconsulting.app.ecommerce.dtos;

import lombok.Data;

@Data
public class CategoryCreationResponseDto {
	private Long id;
    private String name;
    private String description;
}
