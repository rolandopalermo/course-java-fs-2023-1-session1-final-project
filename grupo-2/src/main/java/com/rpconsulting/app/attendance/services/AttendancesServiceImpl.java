package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.attendance.AttendanceCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.attendance.AttendanceCreationResponseDto;
import com.rpconsulting.app.attendance.errors.exceptions.NotFoundException;
import com.rpconsulting.app.attendance.repositories.AttendanceRepository;
import com.rpconsulting.app.attendance.repositories.CourseRepository;
import com.rpconsulting.app.attendance.repositories.StudentRepository;
import com.rpconsulting.app.attendance.repositories.entities.Attendance;
import com.rpconsulting.app.attendance.repositories.entities.Course;
import com.rpconsulting.app.attendance.repositories.entities.Student;
import com.rpconsulting.app.attendance.repositories.enums.Status;
import com.rpconsulting.app.attendance.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class AttendancesServiceImpl implements AttendancesService {

    private final AttendanceRepository attendanceRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public AttendancesServiceImpl(AttendanceRepository attendanceRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public AttendanceCreationResponseDto create(AttendanceCreationRequestDto requestDto) {

        Student student = studentRepository.findFirstByDni(requestDto.getStudent().getDni())
                .orElseThrow(() -> new NotFoundException(MessageFormat.format("El estudiante con dni: {0} no existe", requestDto.getStudent().getDni())));

        Course course = courseRepository.findFirstByCode(requestDto.getCourse().getCode())
                .orElseThrow(() -> new NotFoundException(MessageFormat.format("El Curso con codigo: {0} no existe", requestDto.getCourse().getCode())));

        Attendance attendance = toEntity(requestDto, student, course);

        return toDto(attendanceRepository.save(attendance));
    }

    private Attendance toEntity(AttendanceCreationRequestDto dto, Student student, Course course) {
        Attendance attendance = new Attendance();
        attendance.setStatus(Status.valueOf(dto.getStatus()));
        attendance.setDateCreation(DateUtils.toLocalDate(dto.getDateCreation()));
        attendance.setObservation(dto.getObservation());
        attendance.setStudent(student);
        attendance.setCourse(course);
        return attendance;
    }

    private AttendanceCreationResponseDto toDto(Attendance attendance) {
        AttendanceCreationResponseDto dto = new AttendanceCreationResponseDto();
        dto.setId(attendance.getId());
        dto.setStatus(attendance.getStatus());
        dto.setDateCreation(DateUtils.toString(attendance.getDateCreation()));
        dto.setObservation(attendance.getObservation());
        return dto;
    }

}
