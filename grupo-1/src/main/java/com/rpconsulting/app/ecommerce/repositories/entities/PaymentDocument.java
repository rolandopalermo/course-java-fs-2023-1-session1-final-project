package com.rpconsulting.app.ecommerce.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "payment_documents")
public class PaymentDocument {

    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @GeneratedValue
    private Long id;

    @Column
    private String documentType;

    @Column
    private String paymentType;

    @Column
    private BigDecimal taxAmount;

    @Column
    private BigDecimal total;

    @Column
    private BigDecimal discount;

    @Column
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "paymentDocument")
    private List<DocumentDetail> details = new ArrayList<>();

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
