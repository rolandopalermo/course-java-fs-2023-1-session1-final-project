package com.rpconsulting.app.attendance.controllers;

import com.rpconsulting.app.attendance.dtos.students.StudentCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.students.StudentCreationResponseDto;
import com.rpconsulting.app.attendance.services.StudentsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static com.rpconsulting.app.attendance.utils.Constants.API_VERSION;

@RestController
@RequestMapping(value = {API_VERSION + "students"})
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentCreationResponseDto create(@Valid @RequestBody StudentCreationRequestDto requestDto) {
        return studentsService.create(requestDto);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<StudentCreationResponseDto> findAll(Pageable pageable) {
        return studentsService.findAll(pageable);
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentCreationResponseDto findById(@PathVariable("id") UUID id) {
        return studentsService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable("id") UUID id) {
        studentsService.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentCreationResponseDto update(@PathVariable("id") UUID id, @RequestBody StudentCreationRequestDto requestDto) {
        return studentsService.update(id, requestDto);
    }

}
