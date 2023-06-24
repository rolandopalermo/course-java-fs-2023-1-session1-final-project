package com.rpconsulting.app.attendance.controllers;

import com.rpconsulting.app.attendance.services.StudentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rpconsulting.app.attendance.utils.Constants.API_VERSION_2;

@RestController
@RequestMapping(value = {API_VERSION_2 + "students"})
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }
    

}
