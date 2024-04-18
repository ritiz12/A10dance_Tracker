package com.example.A10dance_Tracker.employeeAttendance.core;

import com.example.A10dance_Tracker.employeeAttendance.data.*;
import com.example.A10dance_Tracker.employeeAttendance.domain.Attendance;
import com.example.A10dance_Tracker.employeeAttendance.persistence.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 Business Operation on Attendance
 **/

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository ;

    public PostLogInResponse saveLogInTimeDate(PostLogInRequest request) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedTime = request.getCurrTime().format(timeFormatter);
        String formattedDate = request.getCurrTime().format(dateFormatter);
        Attendance existingRecord = attendanceRepository.findByLogInDate(request.getCurrTime().toLocalDate());
        if(existingRecord != null && existingRecord.getLogInTime() != null) {
            throw new IllegalStateException("User is Already LogIn For Today !");
        }

        Attendance attendance = new Attendance();
        attendance.setLogInTime(LocalTime.parse(formattedTime, timeFormatter));
        attendance.setLogInDate(LocalDate.parse(formattedDate, dateFormatter));
        attendance = attendanceRepository.save(attendance);

        final  PostLogInResponse response = new PostLogInResponse();
        response.setLogInTime(attendance.getLogInTime());
        response.setLogInDate(attendance.getLogInDate());
        return response;
    }


   public PostLogOutResponse saveLogOutTime(PostLogOutRequest request) {

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedTime = request.getCurrTime().format(timeFormatter);
        String formattedDate = request.getCurrTime().format(dateFormatter);
        Attendance attendance = attendanceRepository.findByLogInDate(LocalDate.parse(formattedDate, dateFormatter));
        attendance.setLogOutTime(LocalTime.parse(formattedTime, timeFormatter));
             attendance = attendanceRepository.save(attendance);
       final   PostLogOutResponse response = new PostLogOutResponse();
        response.setLogOutTime(attendance.getLogOutTime());
        response.setLogOut(true);
        return response;

    }


    public AutomaticPostLogOutResponse automaticSaveLogOutTime()
    {

      final var response = new AutomaticPostLogOutResponse();
        if(!response.getLogOut() )
        {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedTime = currentDateTime.format(timeFormatter);
            String formattedDate = currentDateTime.format(dateFormatter);
            Attendance attendance = attendanceRepository.findByLogInDate(LocalDate.parse(formattedDate, dateFormatter));

            if(attendance != null && attendance.getLogInTime() != null && attendance.getLogOutTime() == null) {
                attendance.setLogOutTime(LocalTime.parse(formattedTime, timeFormatter));
                attendanceRepository.save(attendance);
                response.setLogOutTime(LocalTime.parse(formattedTime, timeFormatter));
            }

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
    public GetPreviousRecordResponse getPreviousRecord() {

        final GetPreviousRecordResponse response = new GetPreviousRecordResponse();

        LocalDate startDate = LocalDate.now().minusDays(6);

        List<Attendance> attendanceRecords = attendanceRepository.findByLogInDateBetween(startDate, LocalDate.now());
    //    Collections.sort(attendanceRecords, Comparator.comparing(Attendance::getLogInDate).reversed());
        Collections.reverse(attendanceRecords);
        for (Attendance record : attendanceRecords) {
            response.addAttendanceRecord(new GetPreviousRecordSummary(
                    record.getLogInTime(),
                    record.getLogOutTime(),
                    record.getLogInDate()
            ));
        }

        return response;
    }
}


