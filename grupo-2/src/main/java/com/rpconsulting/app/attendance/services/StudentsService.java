package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.students.StudentCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.students.StudentCreationResponseDto;

import java.util.UUID;

public interface StudentsService {

    StudentCreationResponseDto create(StudentCreationRequestDto student);

    StudentCreationResponseDto findById(UUID id);

    void deleteById(UUID id);

    StudentCreationResponseDto update(UUID id, StudentCreationRequestDto studentDto);

}
