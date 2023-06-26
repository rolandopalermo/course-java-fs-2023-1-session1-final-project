package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.students.StudentCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.students.StudentCreationResponseDto;
import com.rpconsulting.app.attendance.errors.exceptions.NotFoundException;
import com.rpconsulting.app.attendance.repositories.StudentRepository;
import com.rpconsulting.app.attendance.repositories.entities.Student;
import com.rpconsulting.app.attendance.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;

@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentRepository studentRepository;

    public StudentsServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentCreationResponseDto create(StudentCreationRequestDto student) {
        Student studentToSave = this.toEntity(student);
        return this.toDto(studentRepository.save(studentToSave));
    }

    @Override
    public StudentCreationResponseDto findById(UUID id) {
        Student student = findFirstById(id);
        return toDto(student);
    }

    @Override
    public void deleteById(UUID id) {
        findFirstById(id);
        studentRepository.deleteById(id);
    }

    private Student findFirstById(UUID uuid) {
        return studentRepository.findById(uuid).orElseThrow(
                () -> new NotFoundException(MessageFormat.format("El estudiante con id {0} no existe", uuid)
                ));
    }

    @Override
    public StudentCreationResponseDto update(UUID id, StudentCreationRequestDto studentDto) {
        this.findFirstById(id);
        Student studentUpdate = toEntity(studentDto);
        studentUpdate.setId(id);
        return toDto(studentRepository.save(studentUpdate));
    }

    private Student toEntity(StudentCreationRequestDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setLastName(studentDto.getLastName());
        student.setDni(studentDto.getDni());
        student.setBirthdate(DateUtils.toLocalDate(studentDto.getBirthdate()));
        student.setCellphone(studentDto.getCellphone() == null ? null : studentDto.getCellphone());
        student.setEmail(student.getEmail() == null ? null : student.getEmail());
        return student;
    }

    private StudentCreationResponseDto toDto(Student student) {
        StudentCreationResponseDto studentDto = new StudentCreationResponseDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setLastName(student.getLastName());
        studentDto.setDni(student.getDni());
        studentDto.setBirthdate(DateUtils.toString(student.getBirthdate()));
        studentDto.setCellphone(student.getCellphone() == null ? null : studentDto.getCellphone());
        studentDto.setEmail(student.getEmail() == null ? null : studentDto.getEmail());
        return studentDto;
    }

}
