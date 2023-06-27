package com.rpconsulting.app.attendance.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String description;

    @OneToMany(mappedBy = "course")
    private List<Attendance> attendances = new ArrayList<>();
}
