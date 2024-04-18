package com.example.A10dance_Tracker.employeeAttendance.api;

import com.example.A10dance_Tracker.employeeAttendance.core.AttendanceService;
import com.example.A10dance_Tracker.employeeAttendance.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * API for managing Attendance.
 **/
@CrossOrigin(origins="http://localhost:5173")
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
     * Get Last 5  Days Attendance Record .
     **/
    @RequestMapping("/record")
    @GetMapping
    public ResponseEntity<GetPreviousRecordResponse> getPreviousRecord(final  LocalTime logInTime , final LocalTime logOutTime ,  final LocalDate logInDate)
    {
        GetPreviousRecordResponse response = attendanceService.getPreviousRecord();
        return ResponseEntity.ok(response);
    }


    /**
     * Save LogIn Time and LogIn Date in Database .
     **/

    @PostMapping("/logIn")
    public ResponseEntity<PostLogInResponse> logInTimeDate(@RequestBody PostLogInRequest request) {
        LocalDateTime currTime = request.getCurrTime();
        final var response =  attendanceService.saveLogInTimeDate(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Save LogOut Time in Database matching certain criteria .
     **/

    @RequestMapping("/logOut")
    @PostMapping
    public ResponseEntity<PostLogOutResponse> logOutTime(@RequestBody PostLogOutRequest request )
    {
        PostLogOutResponse response = attendanceService.saveLogOutTime(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Save LogOut Time in Database automatically at 12PM if User do not logOut  .
     **/
    @Scheduled(cron = "0 59 23 ? * MON-FRI")
    public ResponseEntity<AutomaticPostLogOutResponse> automaticSaveLogOutTime()
    {
        AutomaticPostLogOutResponse response = attendanceService.automaticSaveLogOutTime();
        return ResponseEntity.ok(response);
    }

}
