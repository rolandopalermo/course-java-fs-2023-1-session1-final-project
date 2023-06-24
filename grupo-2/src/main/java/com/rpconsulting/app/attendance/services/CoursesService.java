package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.courses.CourseCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.courses.CourseCreationResponseDto;
import com.rpconsulting.app.attendance.dtos.students.StudentCreationRequestDto;

import java.util.UUID;

public interface CoursesService {

    CourseCreationResponseDto create(CourseCreationResponseDto request);

    StudentCreationRequestDto findById(UUID uuid);

    void  deleteById(UUID uuid);

    CourseCreationResponseDto update(CourseCreationRequestDto request);
}
