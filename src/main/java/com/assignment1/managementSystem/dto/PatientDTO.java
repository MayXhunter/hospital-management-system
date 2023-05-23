package com.assignment1.managementSystem.dto;

public class PatientDTO {
    private String name;
    private Integer age;
    private String gender;
    private String insuranceNumber;
    private String phoneNumber;
    private String medicalHistory;

    public PatientDTO() {
    }

    public PatientDTO(String name, Integer age, String gender, String insuranceNumber, String phoneNumber, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.insuranceNumber = insuranceNumber;
        this.phoneNumber = phoneNumber;
        this.medicalHistory = medicalHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}

