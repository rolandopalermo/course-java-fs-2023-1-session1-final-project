package com.rpconsulting.app.attendance.repositories;

import com.rpconsulting.app.attendance.repositories.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("select c from Course c where c.code = :code")
    Optional<Course> findFirstByCode(String code);

}
