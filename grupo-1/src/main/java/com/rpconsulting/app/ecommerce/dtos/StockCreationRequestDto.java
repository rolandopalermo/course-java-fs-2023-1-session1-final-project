package com.rpconsulting.app.ecommerce.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class StockCreationRequestDto {
	BigDecimal quantity;
}
