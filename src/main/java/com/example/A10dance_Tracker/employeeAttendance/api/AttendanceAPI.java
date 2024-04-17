package com.example.A10dance_Tracker.employeeAttendance.api;

import com.example.A10dance_Tracker.employeeAttendance.core.AttendanceService;
import com.example.A10dance_Tracker.employeeAttendance.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * API for managing Attendance.
 **/
@RequestMapping("/attendance")
@RestController
public class AttendanceAPI {

    @Autowired
    private AttendanceService attendanceService;


    /**
     * Get Last 3  Month Wise Total Working Hour.
     **/
    @RequestMapping()
    @GetMapping
    public ResponseEntity<GetMonthlyDataResponse> monthlyWorkingTime(final  LocalTime logInTime , final LocalTime logOutTime ,  final LocalDate logInDate)
    {
        return ResponseEntity.ok(attendanceService.getMonthlyWorkingTime(new GetMonthlyDataRequest(logInTime , logOutTime  , logInDate)));
    }

    /**
     * Save LogIn Time and LogIn Date in Database .
     **/

    @RequestMapping("/logIn")
    @PostMapping
    public ResponseEntity<PostLogInResponse> logInTimeDate()
    {
       PostLogInResponse response =  attendanceService.saveLogInTimeDate();
       return ResponseEntity.ok(response);
    }

    /**
     * Save LogOut Time in Database matching certain criteria .
     **/

    @RequestMapping("/logOut")
    @PostMapping
    public ResponseEntity<PostLogOutResponse> logOutTime()
    {
        PostLogOutResponse response = attendanceService.saveLogOutTime();
        return ResponseEntity.ok(response);
    }

    /**
     * Save LogOut Time in Database automatically at 12PM if User do not logOut  .
     **/
    @Scheduled(cron = "0 0 15 * * *")
    public ResponseEntity<AutomaticPostLogOutResponse> automaticSaveLogOutTime()
    {
        AutomaticPostLogOutResponse response = attendanceService.automaticSaveLogOutTime();
        return ResponseEntity.ok(response);
    }

}
