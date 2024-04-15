package com.example.A10dance_Tracker.employeeAttendance.domain;

import jakarta.persistence.*;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance" )
public class Attendance extends Model{


   // @NonNull()
   // @NotBlank(message = "")
  ////  @NotEmpty(message = "")
    @Column(length = 100 , name = "logInTime" , nullable = true , updatable = false)
    private LocalTime logInTime;

  //  @NonNull()
  //  @NotBlank(message = "")
  //  @NotEmpty(message = "")
    @Column(length = 100 , name = "logOutTime" , nullable = true )
    private LocalTime logOutTime;


  //  @NonNull()
    //@NotBlank(message = "")
    //@NotEmpty(message = "")
    @Column(length = 100 , name = "logInDate" , nullable = true , updatable = false)
    private LocalDate logInDate;




    public Attendance()
    {
        super();
    }

    //@NonNull
    public LocalTime getLogInTime() {
        return logInTime;
    }

    public void setLogInTime( LocalTime logInTime) {
        this.logInTime = logInTime;
    }

   // @NonNull
    public LocalTime getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime( LocalTime logOutTime) {
        this.logOutTime = logOutTime;
    }

   // @NonNull
    public LocalDate getLogInDate() {
        return logInDate;
    }

    public void setLogInDate( LocalDate logInDate) {
        this.logInDate = logInDate;
    }


    public Attendance( LocalTime logInTime,  LocalTime logOutTime,  LocalDate logInDate) {
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
        this.logInDate = logInDate;

    }
}
