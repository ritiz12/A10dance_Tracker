package com.example.A10dance_Tracker.employeeAttendance.data;

import java.time.LocalDate;
import java.time.LocalTime;


public class PostLogInResponse {
    private LocalTime logInTime;
    private LocalDate logInDate;

    // Constructors
    public PostLogInResponse() {
    }

    public PostLogInResponse(LocalTime logInTime, LocalDate logInDate) {
        this.logInTime = logInTime;
        this.logInDate = logInDate;
    }

    // Getters and setters
    public LocalTime getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(LocalTime logInTime) {
        this.logInTime = logInTime;
    }

    public LocalDate getLogInDate() {
        return logInDate;
    }

    public void setLogInDate(LocalDate logInDate) {
        this.logInDate = logInDate;
    }
}
