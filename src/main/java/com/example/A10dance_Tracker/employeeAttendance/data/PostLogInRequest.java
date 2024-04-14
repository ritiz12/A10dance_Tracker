package com.example.A10dance_Tracker.employeeAttendance.data;

import jakarta.persistence.Column;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;

public class PostLogInRequest {
    @NonNull()
    @NotBlank(message = "")
    @NotEmpty(message = "")
    @Column(length = 100 , name = "logInTime" , nullable = false , updatable = false)
    private LocalTime logInTime;

    @NonNull()
    @NotBlank(message = "")
    @NotEmpty(message = "")
    @Column(length = 100 , name = "logInDate" , nullable = false , updatable = false)
    private LocalTime logInDate;

    public PostLogInRequest(@NonNull LocalTime logInTime, @NonNull LocalTime logInDate) {
        this.logInTime = logInTime;
        this.logInDate = logInDate;
    }

    @NonNull
    public LocalTime getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(@NonNull LocalTime logInTime) {
        this.logInTime = logInTime;
    }

    @NonNull
    public LocalTime getLogInDate() {
        return logInDate;
    }

    public void setLogInDate(@NonNull LocalTime logInDate) {
        this.logInDate = logInDate;
    }
}
