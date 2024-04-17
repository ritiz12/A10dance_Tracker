package com.example.A10dance_Tracker.employeeAttendance.data;

import java.time.LocalDate;
import java.time.LocalTime;

public class GetPreviousRecordRequest {
    final private LocalTime logInTime;
    final private LocalTime logOutTime;
    final private LocalDate logInDate ;

    public GetPreviousRecordRequest(LocalTime logInTime, LocalTime logOutTime, LocalDate logInDate) {
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
        this.logInDate = logInDate;
    }

    public LocalTime getLogInTime() {
        return logInTime;
    }

    public LocalTime getLogOutTime() {
        return logOutTime;
    }

    public LocalDate getLogInDate() {
        return logInDate;
    }
}
