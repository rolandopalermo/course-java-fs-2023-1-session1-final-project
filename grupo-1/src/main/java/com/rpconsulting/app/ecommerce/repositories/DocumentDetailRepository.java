package com.rpconsulting.app.ecommerce.repositories;

import com.rpconsulting.app.ecommerce.repositories.entities.DocumentDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDetailRepository extends JpaRepository<DocumentDetail, Long> {
    @Query(value = "SELECT documentDetail from DocumentDetail documentDetail")
    Page<DocumentDetail> findAllDetails(Pageable pageable);
}
