package com.example.A10dance_Tracker.employeeAttendance.api;

import com.example.A10dance_Tracker.employeeAttendance.core.AttendanceService;
import com.example.A10dance_Tracker.employeeAttendance.data.GetMonthlyDataRequest;
import com.example.A10dance_Tracker.employeeAttendance.data.GetMonthlyDataResponse;
import com.example.A10dance_Tracker.employeeAttendance.data.PostLogInResponse;
import com.example.A10dance_Tracker.employeeAttendance.data.PostLogOutResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RequestMapping("/attendance")
@RestController
public class AttendanceAPI {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping()
    @GetMapping
    public ResponseEntity<GetMonthlyDataResponse> monthlyWorkingTime(final  LocalTime logInTime , final LocalTime logOutTime ,  final LocalDate logInDate)
    {
        return ResponseEntity.ok(attendanceService.getMonthlyWorkingTime(new GetMonthlyDataRequest(logInTime , logOutTime  , logInDate)));
    }


    @RequestMapping("/logIn")
    @PostMapping
    public ResponseEntity<PostLogInResponse> logInTimeDate()
    {
       PostLogInResponse response =  attendanceService.saveLogInTimeDate();
       return ResponseEntity.ok(response);
    }


    @RequestMapping("/logOut")
    @PostMapping
    public ResponseEntity<PostLogOutResponse> logOutTime()
    {
        PostLogOutResponse response = attendanceService.saveLogOutTime();
        return ResponseEntity.ok(response);
    }



}
