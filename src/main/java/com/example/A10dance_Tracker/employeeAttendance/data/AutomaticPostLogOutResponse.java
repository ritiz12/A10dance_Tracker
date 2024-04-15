package com.example.A10dance_Tracker.employeeAttendance.data;

import java.time.LocalTime;

public class AutomaticPostLogOutResponse {
    private LocalTime logOutTime;
    private String error;

    private Boolean isLogOut = false ;

    public AutomaticPostLogOutResponse() {
    }
        public LocalTime getLogOutTime() {
        return logOutTime;
    }

        public void setLogOutTime(LocalTime logOutTime) {
        this.logOutTime = logOutTime;
    }

        public String getError() {
        return error;
    }

        public void setError(String error) {
        this.error = error;
    }

        public Boolean getLogOut() {
        return isLogOut;
    }

        public void setLogOut(Boolean logOut) {
        isLogOut = logOut;
    }

}
