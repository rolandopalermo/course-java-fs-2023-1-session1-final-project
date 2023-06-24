package com.rpconsulting.app.attendance.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name="courses")
public class Course {

    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;
}
