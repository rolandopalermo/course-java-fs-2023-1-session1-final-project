package com.rpconsulting.app.ecommerce.projections;

import java.math.BigDecimal;

public interface ProductFilterProjection {
	//category
	String getCategory();
	void setCategory();
	
	//id
	Long getId();
	void setId();
	
	//nombre
	String getProduct();
	void setProduct();
	
	//price
	BigDecimal getPrice();
	void setPrice();
	
	//stock
	BigDecimal getStock();
	void setStock();
}
