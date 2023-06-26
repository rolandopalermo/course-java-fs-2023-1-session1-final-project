package com.rpconsulting.app.attendance.dtos.students;

import lombok.Data;

@Data
public class StudentCreationRequestDto {

    private String name;
    private String lastName;
    private String dni;
    private String birthdate;
    private String cellphone;
    private String email;
}
