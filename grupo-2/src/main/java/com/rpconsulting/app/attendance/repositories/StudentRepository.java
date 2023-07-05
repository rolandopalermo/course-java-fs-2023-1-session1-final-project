package com.rpconsulting.app.attendance.repositories;

import com.rpconsulting.app.attendance.repositories.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Query("select s from Student s where s.dni = :dni")
    Optional<Student> findFirstByDni(String dni);

    @Query(
            value = "SELECT s FROM Student s " +
                    "WHERE (:name IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
                    "(:lastName IS NULL OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))) AND " +
                    "(s.birthdate BETWEEN  COALESCE(:birthdateStart, function('DATE', '1900-01-01') ) AND COALESCE(:birthdateEnd, function('DATE', CURRENT_TIMESTAMP)))",
            countQuery = "SELECT s FROM Student s " +
                    "WHERE (:name IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
                    "(:lastName IS NULL OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))) AND " +
                    "(s.birthdate BETWEEN  COALESCE(:birthdateStart, function('DATE', '1900-01-01') ) AND COALESCE(:birthdateEnd, function('DATE', CURRENT_TIMESTAMP)))"
    )
    Page<Student> findAllByFilters(
            String name,
            String lastName,
            LocalDate birthdateStart,
            LocalDate birthdateEnd,
            Pageable pageable);

}
