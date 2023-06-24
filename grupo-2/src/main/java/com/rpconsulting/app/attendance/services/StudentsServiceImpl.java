package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.students.StudentCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.students.StudentCreationResponseDto;
import com.rpconsulting.app.attendance.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentsServiceImpl implements StudentsService{

    private final StudentRepository studentRepository;

    public StudentsServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentCreationResponseDto create(StudentCreationRequestDto student) {
        return null;
    }

    @Override
    public StudentCreationRequestDto findById(UUID id) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public StudentCreationResponseDto update(StudentCreationRequestDto student) {
        return null;
    }
}
