package com.rpconsulting.app.attendance.dtos.students;

import lombok.Data;

import java.util.UUID;

@Data
public class StudentDto {
    private UUID id;
    private String name;
    private String lastName;
    private String dni;
    private String birthdate;
    private String cellphone;
    private String email;
}
