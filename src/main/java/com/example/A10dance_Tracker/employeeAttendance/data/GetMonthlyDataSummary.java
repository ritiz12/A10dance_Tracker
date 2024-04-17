package com.example.A10dance_Tracker.employeeAttendance.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class GetMonthlyDataSummary {


    final private String  monthYear ;
    final private BigDecimal monthlyWorkingHours ;

    public GetMonthlyDataSummary(String monthYear, BigDecimal monthlyWorkingHours) {
        this.monthYear = monthYear;
        this.monthlyWorkingHours = monthlyWorkingHours;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public BigDecimal getMonthlyWorkingHaours() {
        return monthlyWorkingHours;
    }
}
