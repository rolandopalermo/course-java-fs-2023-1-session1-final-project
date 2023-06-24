package com.rpconsulting.app.attendance.dtos.students;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentCreationRequestDto {

    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthdate;
    private String cellphone;
    private String email;
}
