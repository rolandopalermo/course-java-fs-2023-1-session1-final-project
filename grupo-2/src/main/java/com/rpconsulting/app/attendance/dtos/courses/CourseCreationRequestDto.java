package com.rpconsulting.app.attendance.dtos.courses;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CourseCreationRequestDto {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 6)
    private String code;
    private String description;
}
