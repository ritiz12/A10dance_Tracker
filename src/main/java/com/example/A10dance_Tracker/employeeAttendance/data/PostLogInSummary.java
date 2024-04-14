package com.example.A10dance_Tracker.employeeAttendance.data;

import jakarta.persistence.Column;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;

public class PostLogInSummary {

    @NonNull()
    @NotBlank(message = "")
    @NotEmpty(message = "")
    @Column(length = 100 , name = "logInTime" , nullable = false , updatable = false)
    private   LocalTime logInTime;

    @NonNull()
    @NotBlank(message = "")
    @NotEmpty(message = "")
    @Column(length = 100 , name = "logInDate" , nullable = false , updatable = false)
    private  LocalDate logInDate;

    public PostLogInSummary(@NonNull LocalTime logInTime, @NonNull LocalDate logInDate) {
        this.logInTime = logInTime;
        this.logInDate = logInDate;
    }

    public PostLogInSummary() {
        super();
    }

    @NonNull
    public LocalTime getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(@NonNull LocalTime logInTime) {
        this.logInTime = logInTime;
    }

    @NonNull
    public LocalDate getLogInDate() {
        return logInDate;
    }

    public void setLogInDate(@NonNull LocalDate logInDate) {
        this.logInDate = logInDate;
    }
}
