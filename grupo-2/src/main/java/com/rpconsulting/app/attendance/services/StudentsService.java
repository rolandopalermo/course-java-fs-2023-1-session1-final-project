package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.students.StudentCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.students.StudentCreationResponseDto;
import com.rpconsulting.app.attendance.dtos.students.StudentDto;
import com.rpconsulting.app.attendance.dtos.students.StudentListFilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface StudentsService {

    StudentCreationResponseDto create(StudentCreationRequestDto studentDto);

    StudentCreationResponseDto findById(UUID id);

    void deleteById(UUID id);

    StudentCreationResponseDto update(UUID id, StudentCreationRequestDto studentDto);

    Page<StudentCreationResponseDto> findAll(Pageable pageable);

    Page<StudentCreationResponseDto> findAllByFilters(StudentListFilterDto filterDto, Pageable pageable);

}
