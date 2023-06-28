package com.rpconsulting.app.attendance.controllers;

import com.rpconsulting.app.attendance.dtos.courses.CourseCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.courses.CourseCreationResponseDto;
import com.rpconsulting.app.attendance.services.CoursesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static com.rpconsulting.app.attendance.utils.Constants.API_VERSION;

@RestController
@RequestMapping(value = {API_VERSION + "courses"})
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseCreationResponseDto create(@Valid @RequestBody CourseCreationRequestDto requestDto) {
        return coursesService.create(requestDto);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CourseCreationResponseDto> findAll(Pageable pageable) {
        return coursesService.findAll(pageable);
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CourseCreationResponseDto findById(@PathVariable("id") UUID uuid) {
        return coursesService.findById(uuid);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable("id") UUID uuid) {
        coursesService.deleteById(uuid);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CourseCreationResponseDto update(@PathVariable("id") UUID uuid, @RequestBody CourseCreationRequestDto request) {
        return coursesService.update(uuid, request);
    }
}
