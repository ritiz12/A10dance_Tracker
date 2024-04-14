package com.example.A10dance_Tracker.employeeAttendance.data;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Map;

public class GetMonthlyDataResponse {
    private Map<Month, BigDecimal> monthWiseData;
    public void setMonthWiseData(Map<Month, BigDecimal> monthWiseData) {
        this.monthWiseData = monthWiseData;
    }

    public Map<Month, BigDecimal> getMonthWiseData() {
        return monthWiseData;
    }
}
