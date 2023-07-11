package com.rpconsulting.app.ecommerce.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rpconsulting.app.ecommerce.repositories.StockRepository;
import com.rpconsulting.app.ecommerce.repositories.entities.Product;
import com.rpconsulting.app.ecommerce.repositories.entities.Stock;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
	
	private final StockRepository stockRepository;
	
	@Override
	public Stock updateStock(Product producto, BigDecimal quantity) {
		Optional<Stock> currentStock = stockRepository.findCurrentStock(producto.getId());
		Stock newStock = new Stock();
		newStock.setProduct(producto);
		newStock.setQuantity(quantity);
		if (currentStock.isPresent()) {
			newStock.setStock(currentStock.get().getStock().add(quantity));
    	} else {
    		newStock.setStock(quantity);
    	}
		newStock.setCreatedAt(LocalDateTime.now());
		return stockRepository.save(newStock);
	}
}
