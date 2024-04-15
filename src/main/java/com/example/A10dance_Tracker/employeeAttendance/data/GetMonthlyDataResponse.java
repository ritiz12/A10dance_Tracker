package com.example.A10dance_Tracker.employeeAttendance.data;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class
GetMonthlyDataResponse {
    private Collection<GetMonthlyDataSummary> monthWiseData;


   public void addMonthWiseData(final GetMonthlyDataSummary data)
   {
       if(monthWiseData == null)
       {
           monthWiseData = new ArrayList<>();
           
       }
       monthWiseData.add(data);
   }

    public Collection<GetMonthlyDataSummary> getMonthWiseData() {
        return Collections.unmodifiableCollection(monthWiseData);
    }
}
