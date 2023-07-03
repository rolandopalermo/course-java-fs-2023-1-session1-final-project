package com.rpconsulting.app.ecommerce.repositories;

import com.rpconsulting.app.ecommerce.repositories.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    @Query(value = "SELECT * FROM customers c WHERE c.id = :id", nativeQuery = true)
    Optional<Customer> findById(Long id);
}
