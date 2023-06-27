package com.rpconsulting.app.attendance.dtos.students;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class StudentCreationRequestDto {

    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String lastName;
    @NotEmpty
    @NotNull
    @Size(min = 5, max = 20)
    private String dni;
    @NotEmpty
    @NotNull
    private String birthdate;
    private String cellphone;
    @Email
    private String email;
}
