package com.example.A10dance_Tracker.employeeAttendance.core;

import com.example.A10dance_Tracker.employeeAttendance.data.*;
import com.example.A10dance_Tracker.employeeAttendance.domain.Attendance;
import com.example.A10dance_Tracker.employeeAttendance.persistence.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Business Operation on Attendance
 **/

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository ;

    public PostLogInResponse saveLogInTimeDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
        String formattedTime = currentDateTime.format(timeFormatter);
        String formattedDate = currentDateTime.format(dateFormatter);
        Attendance attendance = new Attendance();
        attendance.setLogInTime(LocalTime.parse(formattedTime, timeFormatter));
        attendance.setLogInDate(LocalDate.parse(formattedDate, dateFormatter));
        attendanceRepository.save(attendance);
      final   PostLogInResponse response = new PostLogInResponse();
        response.setLogInTime(LocalTime.parse(formattedTime, timeFormatter));
        response.setLogInDate(LocalDate.parse(formattedDate, dateFormatter));

        return response;
    }


   public PostLogOutResponse saveLogOutTime() {


        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedTime = currentDateTime.format(timeFormatter);
        String formattedDate = currentDateTime.format(dateFormatter);
        Attendance attendance = attendanceRepository.findByLogInDate(LocalDate.parse(formattedDate, dateFormatter));
        attendance.setLogOutTime(LocalTime.parse(formattedTime, timeFormatter));
        attendanceRepository.save(attendance);
       final   PostLogOutResponse response = new PostLogOutResponse();
        response.setLogOutTime(LocalTime.parse(formattedTime, timeFormatter));
        response.setLogOut(true);
        return response;

    }


    public AutomaticPostLogOutResponse automaticSaveLogOutTime()
    {
      final var response = new AutomaticPostLogOutResponse();
        if(!response.getLogOut())
        {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedTime = currentDateTime.format(timeFormatter);
            String formattedDate = currentDateTime.format(dateFormatter);
            Attendance attendance = attendanceRepository.findByLogInDate(LocalDate.parse(formattedDate, dateFormatter));
            attendance.setLogOutTime(LocalTime.parse(formattedTime, timeFormatter));
            attendanceRepository.save(attendance);
            response.setLogOutTime(LocalTime.parse(formattedTime, timeFormatter));


        }
        response.setLogOut(false);
        return response;
    }

    public GetMonthlyDataResponse getMonthlyWorkingTime(GetMonthlyDataRequest getMonthlyDataRequest) {
        final  var  response = new GetMonthlyDataResponse();
        LocalDate startDate = LocalDate.now().minusMonths(2).withDayOfMonth(1);

        final  List<Attendance> attendanceRecordList = attendanceRepository.findByLogInDateGreaterThanEqual(startDate);
        Map<String, BigDecimal> map = new HashMap<>();
        for(final var attendance : attendanceRecordList)
        {
            if (attendance.getLogInTime() != null && attendance.getLogOutTime() != null )
            {
                long workingTimeInMinutes = ChronoUnit.MINUTES.between(attendance.getLogInTime(), attendance.getLogOutTime());
                BigDecimal workingTimeInHours = BigDecimal.valueOf(workingTimeInMinutes).divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);
                Month month = attendance.getLogInDate().getMonth();
                int  year = attendance.getLogInDate().getYear();
                String monthYear = String.valueOf(month) + " " + year;
                map.put(monthYear, map.getOrDefault(monthYear, BigDecimal.ZERO).add(workingTimeInHours));

            }
        }
        for (final var entry: map.entrySet()) {
            response.addMonthWiseData(new GetMonthlyDataSummary(entry.getKey(),entry.getValue()));
        }
        return response;
    }
}


