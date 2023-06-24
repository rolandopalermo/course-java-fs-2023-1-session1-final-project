package com.rpconsulting.app.attendance.dtos.students;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class StudentCreationResponseDto {

    private UUID id;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthdate;
    private String cellphone;
    private String email;
}
