package com.rpconsulting.app.ecommerce.dtos;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductFilterDto {
	private String nameProduct;
	private BigDecimal priceProduct;
	private String nameCategory;
}
