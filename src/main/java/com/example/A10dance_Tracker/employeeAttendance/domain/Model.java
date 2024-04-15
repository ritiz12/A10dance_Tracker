package com.example.A10dance_Tracker.employeeAttendance.domain;


import jakarta.persistence.*;
import org.hibernate.annotations.GenerationTime;

import javax.annotation.processing.Generated;

@MappedSuperclass
public abstract class Model {

    @Column(name = "id" , updatable = false)
   // @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long id;
    public Long getId() {
        return id;
    }
}
