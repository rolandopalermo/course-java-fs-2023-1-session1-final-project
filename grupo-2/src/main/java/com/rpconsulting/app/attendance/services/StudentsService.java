package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.students.StudentCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.students.StudentCreationResponseDto;

import java.util.UUID;

public interface StudentsService {

    StudentCreationResponseDto create(StudentCreationRequestDto student);

    StudentCreationRequestDto findById(UUID id);

    void deleteById(UUID uuid);

    StudentCreationResponseDto update(StudentCreationRequestDto student);

}
