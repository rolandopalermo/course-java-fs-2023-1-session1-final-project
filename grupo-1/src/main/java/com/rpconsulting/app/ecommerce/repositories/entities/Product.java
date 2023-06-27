package com.rpconsulting.app.ecommerce.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Stock> stocks = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<DocumentDetail> details = new ArrayList<>();
}
