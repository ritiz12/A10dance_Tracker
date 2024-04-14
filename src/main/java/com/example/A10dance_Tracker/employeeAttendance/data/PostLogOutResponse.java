package com.example.A10dance_Tracker.employeeAttendance.data;

import java.time.LocalDate;
import java.time.LocalTime;

public class PostLogOutResponse {
private LocalTime logOutTime;

    public LocalTime getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(LocalTime logOutTime) {
        this.logOutTime = logOutTime;
    }

    public void setLogOutDate(LocalDate parse) {
    }
}
