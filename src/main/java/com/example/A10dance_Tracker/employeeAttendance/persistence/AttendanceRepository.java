package com.example.A10dance_Tracker.employeeAttendance.persistence;

import com.example.A10dance_Tracker.employeeAttendance.data.GetMonthlyDataSummary;
import com.example.A10dance_Tracker.employeeAttendance.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,String> {

     @Query("SELECT a FROM Attendance a WHERE a.logInDate = :logInDate")
     Attendance findByLogInDate(@Param("logInDate") LocalDate logInDate);
     List<Attendance> findByLogInDateGreaterThanEqual(LocalDate startDate);

    Attendance findTopByOrderByLogInDateDesc();
}
