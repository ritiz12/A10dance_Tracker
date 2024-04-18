package com.example.A10dance_Tracker.employeeAttendance.data;

import java.time.LocalTime;

public class PostLogOutSummary {
    final private LocalTime currTime ;

    public PostLogOutSummary(LocalTime currTime) {
        this.currTime = currTime;
    }

    public LocalTime getCurrTime() {
        return currTime;
    }
}
