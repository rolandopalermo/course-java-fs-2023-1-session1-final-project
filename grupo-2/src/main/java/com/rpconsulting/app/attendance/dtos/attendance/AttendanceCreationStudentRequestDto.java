package com.rpconsulting.app.attendance.dtos.attendance;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AttendanceCreationStudentRequestDto {

    @NotEmpty
    @NotNull
    @Size(min = 5, max = 20)
    private String dni;
    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String firstName;
}
