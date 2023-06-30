package com.rpconsulting.app.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rpconsulting.app.ecommerce.repositories.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE p.name = :name")
	Optional<Product> findFirstByName(String name);
	
}
