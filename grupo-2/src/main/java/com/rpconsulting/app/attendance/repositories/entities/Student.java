package com.rpconsulting.app.attendance.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String dni;

    @Column
    private LocalDate birthdate;

    @Column
    private String cellphone;

    @Column
    private String email;

}
