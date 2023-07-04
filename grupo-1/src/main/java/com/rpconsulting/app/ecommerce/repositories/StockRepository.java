package com.rpconsulting.app.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rpconsulting.app.ecommerce.repositories.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	@Query(value = "select * from STOCKS s where s.product_id = :id order by created_at desc limit 1", nativeQuery = true)
	Optional<Stock> findCurrentStock(long id);

}
