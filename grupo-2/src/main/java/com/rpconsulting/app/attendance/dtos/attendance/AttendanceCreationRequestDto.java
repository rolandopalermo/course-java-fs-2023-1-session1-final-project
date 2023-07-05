package com.rpconsulting.app.attendance.dtos.attendance;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AttendanceCreationRequestDto {

    @NotEmpty
    @NotNull
    @Pattern(regexp = "PRESENT|ABSENT|LATE")
    private String status;
    @NotEmpty
    @NotNull
    private String dateCreation;
    private String observation;

    @NotEmpty
    @NotNull
    private String studentDni;

    @NotEmpty
    @NotNull
    private String courseCode;

}
