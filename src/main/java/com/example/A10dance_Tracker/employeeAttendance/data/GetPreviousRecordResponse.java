package com.example.A10dance_Tracker.employeeAttendance.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GetPreviousRecordResponse {

     private Collection<GetPreviousRecordSummary> attendanceRecords ;

    public void addAttendanceRecord(final GetPreviousRecordSummary record)
    {
        if(attendanceRecords == null)
        {
            attendanceRecords = new ArrayList<>();
        }
        attendanceRecords.add(record);


    }

    public Collection<GetPreviousRecordSummary> getAttendanceRecords() {
        return Collections.unmodifiableCollection(attendanceRecords);
    }
}
