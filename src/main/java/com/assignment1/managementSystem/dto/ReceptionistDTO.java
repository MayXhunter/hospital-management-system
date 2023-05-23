package com.assignment1.managementSystem.dto;

public class ReceptionistDTO {
    private String name;

    public ReceptionistDTO() {
    }

    public ReceptionistDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}