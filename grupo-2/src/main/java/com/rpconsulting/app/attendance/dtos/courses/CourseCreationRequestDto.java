package com.rpconsulting.app.attendance.dtos.courses;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CourseCreationRequestDto {

    private String name;
    private String description;
}
