package com.rpconsulting.app.ecommerce.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String dni;

    @Column
    private String email;

    @Column
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<PaymentDocument> orders = new ArrayList<>();
}
