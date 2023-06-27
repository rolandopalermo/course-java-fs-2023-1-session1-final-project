package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.courses.CourseCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.courses.CourseCreationResponseDto;
import com.rpconsulting.app.attendance.dtos.students.StudentCreationRequestDto;
import com.rpconsulting.app.attendance.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CoursesServiceImpl implements CoursesService{

    private final CourseRepository courseRepository;

    public CoursesServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseCreationResponseDto create(CourseCreationResponseDto request) {
        return null;
    }

    @Override
    public StudentCreationRequestDto findById(UUID uuid) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public CourseCreationResponseDto update(CourseCreationRequestDto request) {
        return null;
    }
}
