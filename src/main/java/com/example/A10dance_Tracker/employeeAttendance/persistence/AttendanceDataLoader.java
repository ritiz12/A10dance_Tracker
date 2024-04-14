package com.example.A10dance_Tracker.employeeAttendance.persistence;

import com.example.A10dance_Tracker.employeeAttendance.domain.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public class AttendanceDataLoader implements CommandLineRunner {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public void run(String... args) throws Exception {
       // generateDummyDataForMonth(2023, 7);
        generateDummyDataForMonth(2024, 3);
        generateDummyDataForMonth(2024, 4);
        generateDummyDataForMonth(2024, 2);

    }
    private void generateDummyDataForMonth(int year, int month) {
        // Set the year and month for which you want to generate data
        LocalDate date = LocalDate.of(year, month, 1);

        // Generate dummy attendance records for each day of the month
        for (int day = 1; day <= date.lengthOfMonth(); day++) {
            // Example: Generate login and logout times for each day
            LocalTime loginTime = LocalTime.of(8, 0); // Example login time
            LocalTime logoutTime = LocalTime.of(17, 0); // Example logout time

            // Create an Attendance object with the generated login and logout times
            Attendance attendance = new Attendance(loginTime, logoutTime, date);

            // Save the attendance record to the database
            attendanceRepository.save(attendance);

            // Move to the next day
            date = date.plusDays(1);
        }
    }
}
