package com.example.A10dance_Tracker.employeeAttendance.persistence;

import com.example.A10dance_Tracker.employeeAttendance.data.GetMonthlyDataSummary;
import com.example.A10dance_Tracker.employeeAttendance.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,String> {
    Attendance findByLogInDate(LocalDate parse);

    List<GetMonthlyDataSummary> findByLogInDateGreaterThanEqual(LocalDate startDate);
    //
   //void save(GetLogInSummary logInSummary);
}
