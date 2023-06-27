package com.rpconsulting.app.attendance.dtos.attendance;

import com.rpconsulting.app.attendance.repositories.enums.Status;
import lombok.Data;

import java.util.UUID;

@Data
public class AttendanceCreationResponseDto {

    private UUID id;
    private Status status;
    private String dateCreation;
    private String observation;
}
