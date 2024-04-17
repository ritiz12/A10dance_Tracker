package com.example.A10dance_Tracker.employeeAttendance.domain;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Model {

    @Id
  //  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
}
