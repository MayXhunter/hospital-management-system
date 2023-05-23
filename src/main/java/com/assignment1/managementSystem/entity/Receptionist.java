package com.assignment1.managementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receptionist")
public class Receptionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;

    public Receptionist() {
    }

    public Receptionist(Long employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                '}';
    }
}
