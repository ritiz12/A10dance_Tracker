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
        generateDummyDataForAprilMonth(2024, 4);
        generateDummyDataForMonth(2024, 3);
        generateDummyDataForMonth(2024, 2);
        generateDummyDataForMonth(2024, 1);
        generateDummyDataForMonth(2023, 12);
        generateDummyDataForMonth(2023, 11);
        generateDummyDataForMonth(2023, 10);

    }

    private void generateDummyDataForAprilMonth(int year, int month) {

        LocalDate date = LocalDate.of(year, month, 1);
        for (int day = 1; day <=  16; day++) {

            LocalTime loginTime = LocalTime.of(8, 0);
            LocalTime logoutTime = LocalTime.of(17, 0);
            Attendance attendance = new Attendance(loginTime, logoutTime, date);
            attendanceRepository.save(attendance);
            date = date.plusDays(1);
        }
    }

    private void generateDummyDataForMonth(int year, int month) {
        // Set the year and month for which you want to generate data
        LocalDate date = LocalDate.of(year, month, 1);
        for (int day = 1; day <= date.lengthOfMonth(); day++) {

            LocalTime loginTime = LocalTime.of(8, 0);
            LocalTime logoutTime = LocalTime.of(17, 0);
            Attendance attendance = new Attendance(loginTime, logoutTime, date);
            attendanceRepository.save(attendance);
            date = date.plusDays(1);
        }

    }
}