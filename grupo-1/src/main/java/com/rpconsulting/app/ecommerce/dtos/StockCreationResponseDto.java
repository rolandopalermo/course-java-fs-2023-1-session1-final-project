package com.rpconsulting.app.ecommerce.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class StockCreationResponseDto {
	long productId;
	BigDecimal currentStock;
}
