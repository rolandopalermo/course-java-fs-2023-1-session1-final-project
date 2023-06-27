package com.rpconsulting.app.attendance.controllers;

import com.rpconsulting.app.attendance.services.CoursesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.rpconsulting.app.attendance.utils.Constants.API_VERSION_2;

@RestController
@RequestMapping(value = {API_VERSION_2 + "courses"})
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }
}
