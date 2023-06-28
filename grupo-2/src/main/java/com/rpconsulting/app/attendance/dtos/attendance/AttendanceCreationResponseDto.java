package com.rpconsulting.app.attendance.dtos.attendance;

import lombok.Data;

import java.util.UUID;

@Data
public class AttendanceCreationResponseDto {

    private UUID id;
    private String status;
    private String dateCreation;
    private String observation;
}
