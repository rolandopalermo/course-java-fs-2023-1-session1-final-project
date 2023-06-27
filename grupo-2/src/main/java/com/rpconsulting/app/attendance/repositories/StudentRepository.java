package com.rpconsulting.app.attendance.repositories;

import com.rpconsulting.app.attendance.repositories.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Query("select s from Student s where s.dni = :dni")
    Optional<Student> findFirstByDni(String dni);
}
