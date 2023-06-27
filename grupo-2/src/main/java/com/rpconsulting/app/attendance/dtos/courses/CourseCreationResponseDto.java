package com.rpconsulting.app.attendance.dtos.courses;

import lombok.Data;

import java.util.UUID;

@Data
public class CourseCreationResponseDto {

    private UUID id;
    private String name;
    private String code;
    private String description;
}
