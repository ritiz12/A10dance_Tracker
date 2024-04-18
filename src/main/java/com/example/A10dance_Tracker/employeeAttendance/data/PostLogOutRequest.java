package com.example.A10dance_Tracker.employeeAttendance.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class PostLogOutRequest {


        private LocalDateTime currTime;

        // Default constructor

    public PostLogOutRequest() {
        // Initialize currTime to the current time
        this.currTime = LocalDateTime.now();
    }
        public LocalDateTime getCurrTime() {
            return currTime;
        }

    public void setCurrTime(LocalDateTime currTime) {
        this.currTime = currTime;
    }
        }

