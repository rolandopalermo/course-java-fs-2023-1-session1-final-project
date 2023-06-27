package com.rpconsulting.app.attendance.dtos.attendance;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AttendanceCreationCourseRequestDto {

    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 6)
    private String code;
    private String description;
}
