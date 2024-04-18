package com.example.A10dance_Tracker.employeeAttendance.data;

import java.time.LocalDateTime;

public class PostLogInSummary {
    private LocalDateTime currTime;

    public PostLogInSummary(LocalDateTime currTime) {
        this.currTime = currTime;
    }

    public LocalDateTime getCurrTime() {
        return currTime;
    }

    public void setCurrTime(LocalDateTime currTime) {
        this.currTime = currTime;
    }
}
