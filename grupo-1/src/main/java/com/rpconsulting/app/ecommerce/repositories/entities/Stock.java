package com.rpconsulting.app.ecommerce.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @GeneratedValue
    private Long id;

    @Column
    private BigDecimal quantity;
    
    @Column
    private BigDecimal stock;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
