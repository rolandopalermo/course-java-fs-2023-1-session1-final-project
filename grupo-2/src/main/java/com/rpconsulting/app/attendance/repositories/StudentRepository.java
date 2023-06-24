package com.rpconsulting.app.attendance.repositories;

import com.rpconsulting.app.attendance.repositories.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
}
