package com.example.A10dance_Tracker;

import com.example.A10dance_Tracker.employeeAttendance.core.AttendanceService;
import com.example.A10dance_Tracker.employeeAttendance.persistence.AttendanceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class A10danceTrackerApplicationTests {

	@Autowired
	AttendanceRepository attendanceRepository;

	@Autowired
	AttendanceService attendanceService;

	@Test
	public void loginTest() {
		LocalDate localDate = LocalDate.now();
		attendanceService.saveLogInTimeDate();

		assertEquals(localDate, attendanceRepository.findTopByOrderByLogInDateDesc().getLogInDate());
	}

}
