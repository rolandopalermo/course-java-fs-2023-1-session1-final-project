package com.rpconsulting.app.ecommerce.repositories;

import com.rpconsulting.app.ecommerce.repositories.entities.PaymentDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDocumentRepository extends JpaRepository<PaymentDocument, Long> {
}
