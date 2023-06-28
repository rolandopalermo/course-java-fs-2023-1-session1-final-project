package com.rpconsulting.app.attendance.repositories;

import com.rpconsulting.app.attendance.repositories.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("select c from Course c where c.code = :code")
    Optional<Course> findFirstByCode(String code);

    @Query("select c from Course c where c.name = :name")
    Optional<Course> findFirstByName(String name);

    @Query(
            value = "SELECT c FROM Course c "+
                    "WHERE (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
                    "(:code IS NULL OR LOWER(c.code) LIKE LOWER(CONCAT('%', :code, '%')))",
            countQuery = "SELECT COUNT(1) FROM Course c "+
            "WHERE (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:code IS NULL OR LOWER(c.code) LIKE LOWER(CONCAT('%', :code, '%')))"
    )
    Page<Course> findAllByFilters(String name, String code, Pageable pageable);
}
