package com.example.A10dance_Tracker.employeeAttendance.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

public class PostLogInRequest {


    private LocalDateTime currTime;

    public PostLogInRequest() {
        // Default constructor
    }
    public PostLogInRequest(LocalDateTime currTime) {
        this.currTime = currTime;
    }

    public LocalDateTime getCurrTime() {
        return currTime;
    }

    public void setCurrTime(LocalDateTime currTime) {
        this.currTime = currTime;
    }


}
