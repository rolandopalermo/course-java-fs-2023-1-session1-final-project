package com.rpconsulting.app.attendance.services;

import com.rpconsulting.app.attendance.dtos.attendance.AttendanceCreationRequestDto;
import com.rpconsulting.app.attendance.dtos.attendance.AttendanceCreationResponseDto;

public interface AttendancesService {

    AttendanceCreationResponseDto create(AttendanceCreationRequestDto requestDto);

}
