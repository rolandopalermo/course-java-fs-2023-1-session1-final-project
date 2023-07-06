package com.rpconsulting.app.ecommerce.repositories;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rpconsulting.app.ecommerce.projections.ProductFilterProjection;
import com.rpconsulting.app.ecommerce.repositories.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE p.name = :name")
	Optional<Product> findFirstByName(String name);
	
	@Query(
            value = "select c.name category, p.id id, p.name product, p.price price, s.stock stock from products p "
            		+ "inner join categories c on p.category_id=c.id "
            		+ "inner join stocks s on s.product_id=p.id "
            		+ "where s.id=(select st.id from stocks st where st.product_id=p.id order by st.created_at desc limit 1) "
            		+ " and (:nameProduct IS NULL OR UPPER(p.name) LIKE UPPER('%' || :nameProduct || '%'))"
            		+ " and (:priceMin IS NULL OR p.price >= :priceMin)"
            		+ " and (:priceMax IS NULL OR p.price <= :priceMax)"
            		+ " and (:nameCategory IS NULL OR UPPER(c.name) LIKE UPPER('%' || :nameCategory || '%'))",
            countQuery = "select c.name category, p.id id, p.name product, p.price price, s.stock stock from products p "
            		+ "inner join categories c on p.category_id=c.id "
            		+ "inner join stocks s on s.product_id=p.id "
            		+ "where s.id=(select st.id from stocks st where st.product_id=p.id order by st.created_at desc limit 1) "
            		+ " and (:nameProduct IS NULL OR UPPER(p.name) LIKE UPPER('%' || :nameProduct || '%'))"
            		+ " and (:priceMin IS NULL OR p.price >= :priceMin)"
            		+ " and (:priceMax IS NULL OR p.price <= :priceMax)"
            		+ " and (:nameCategory IS NULL OR UPPER(c.name) LIKE UPPER('%' || :nameCategory || '%'))", nativeQuery = true)
	Page<ProductFilterProjection> findListProduct(String nameProduct, BigDecimal priceMin, BigDecimal priceMax, String nameCategory, Pageable categoryName);
	
}
