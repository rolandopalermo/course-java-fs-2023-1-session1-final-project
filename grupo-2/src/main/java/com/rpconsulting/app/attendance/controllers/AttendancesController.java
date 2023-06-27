package com.rpconsulting.app.attendance.controllers;

import com.rpconsulting.app.attendance.dtos.attendance.AttendanceCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.attendance.AttendanceCreationResponseDto;
import com.rpconsulting.app.attendance.services.AttendancesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.rpconsulting.app.attendance.utils.Constants.API_VERSION;

@RestController
@RequestMapping(value = {API_VERSION + "attendances"})
public class AttendancesController {

    private final AttendancesService attendancesService;

    public AttendancesController(AttendancesService attendancesService) {
        this.attendancesService = attendancesService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AttendanceCreationResponseDto create(@Valid @RequestBody AttendanceCreationRequestDto requestDto) {
        return attendancesService.create(requestDto);
    }
}
