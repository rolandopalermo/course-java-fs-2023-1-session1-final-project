package com.rpconsulting.app.attendance.dtos.attendance;

import com.rpconsulting.app.attendance.repositories.enums.Status;
import lombok.Data;

import javax.validation.Valid;
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

    @Valid
    private AttendanceCreationStudentRequestDto student;
    @Valid
    private AttendanceCreationCourseRequestDto course;
}
