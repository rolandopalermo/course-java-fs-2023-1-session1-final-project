package com.rpconsulting.app.attendance.dtos.students;

import lombok.Data;

@Data
public class StudentListFilterDto {

    private String name;
    private String lastName;
    private String birthdateStart;
    private String birthdateEnd;
}
