package com.rpconsulting.app.ecommerce.repositories;

import com.rpconsulting.app.ecommerce.repositories.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
