package com.example.A10dance_Tracker.employeeAttendance.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class GetMonthlyDataSummary {


    final private String  monthYear ;
    final private BigDecimal MonthlyWorkingHaours ;

    public GetMonthlyDataSummary(String monthYear, BigDecimal monthlyWorkingHaours) {
        this.monthYear = monthYear;
        MonthlyWorkingHaours = monthlyWorkingHaours;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public BigDecimal getMonthlyWorkingHaours() {
        return MonthlyWorkingHaours;
    }
}
