package com.rpconsulting.app.attendance.repositories.entities;

import com.rpconsulting.app.attendance.repositories.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @Column
    private LocalDate dateCreation;

    @Column
    private String observation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}
