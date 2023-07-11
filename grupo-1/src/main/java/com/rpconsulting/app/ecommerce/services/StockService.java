package com.rpconsulting.app.ecommerce.services;

import java.math.BigDecimal;

import com.rpconsulting.app.ecommerce.repositories.entities.Product;
import com.rpconsulting.app.ecommerce.repositories.entities.Stock;

public interface StockService {
	
	Stock updateStock(Product producto, BigDecimal quantity);
	
}
