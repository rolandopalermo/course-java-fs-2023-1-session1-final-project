package com.rpconsulting.app.ecommerce.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "document_details")
public class DocumentDetail {

    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @GeneratedValue
    private Long id;

    @Column
    private BigDecimal quantity;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private PaymentDocument paymentDocument;

    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
