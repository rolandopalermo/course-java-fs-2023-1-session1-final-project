package com.rpconsulting.app.ecommerce.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductSumaryDto {
	private String categoryProduct;
	private long idProduct;
	private String nameProduct;
	private BigDecimal priceProduct;
	private BigDecimal stockProduct;
}
