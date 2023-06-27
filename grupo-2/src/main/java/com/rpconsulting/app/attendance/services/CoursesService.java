package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.courses.CourseCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.courses.CourseCreationResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CoursesService {

    CourseCreationResponseDto create(CourseCreationRequestDto request);

    CourseCreationResponseDto findById(UUID uuid);

    void  deleteById(UUID uuid);

    CourseCreationResponseDto update(UUID uuid, CourseCreationRequestDto request);

    Page<CourseCreationResponseDto> findAll(Pageable pageable);
}
