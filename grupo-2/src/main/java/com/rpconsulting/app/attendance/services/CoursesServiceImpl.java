package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.courses.CourseCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.courses.CourseCreationResponseDto;
import com.rpconsulting.app.attendance.errors.exceptions.AlreadyExistsException;
import com.rpconsulting.app.attendance.errors.exceptions.NotFoundException;
import com.rpconsulting.app.attendance.repositories.CourseRepository;
import com.rpconsulting.app.attendance.repositories.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CoursesServiceImpl implements CoursesService {

    private final CourseRepository courseRepository;

    public CoursesServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseCreationResponseDto create(CourseCreationRequestDto request) {
        Optional<Course> courseExists = courseRepository.findFirstByCode(request.getCode());
        if(courseExists.isPresent()){
            throw new AlreadyExistsException(MessageFormat.format("El curso con codigo: {0} ya existe", request.getCode()));
        }
        Course courseToSave = toEntity(request);
        return toDto(courseRepository.save(courseToSave));
    }

    private CourseCreationResponseDto toDto(Course course){
        CourseCreationResponseDto response = new CourseCreationResponseDto();
        response.setDescription(course.getDescription());
        response.setId(course.getId());
        response.setName(course.getName());
        response.setCode(course.getCode());
        return response;
    }

    private Course toEntity(CourseCreationRequestDto request){
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setCode(request.getCode());
        return course;
    }

    public CourseCreationResponseDto findById(UUID uuid) {
        Course course = findFirstById(uuid);
        return toDto(course);
    }

    private Course findFirstById(UUID uuid){
        return  courseRepository.findById(uuid).orElseThrow(
                ()-> new NotFoundException(
                        MessageFormat.format("El Curso con id {0} no existe", uuid)
                )
        );
    }

    @Override
    public void deleteById(UUID uuid) {
        findFirstById(uuid);
        courseRepository.deleteById(uuid);
    }

    @Override
    public CourseCreationResponseDto update(UUID uuid, CourseCreationRequestDto request) {
        findFirstById(uuid);
        Course courseUpdate = toEntity(request);
        courseUpdate.setId(uuid);
        return toDto(courseRepository.save(courseUpdate));
    }

    @Override
    public Page<CourseCreationResponseDto> findAll(Pageable pageable) {
        Page<Course> page = courseRepository.findAll(pageable);
        return new PageImpl<>(
                page.stream().map(this::toDto)
                        .collect(Collectors.toList()),
                page.getPageable(),
                page.getTotalElements()
        );
    }
}
