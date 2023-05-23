package com.assignment1.managementSystem.controller;

import com.assignment1.managementSystem.dto.PatientDTO;
import com.assignment1.managementSystem.entity.Patient;
import com.assignment1.managementSystem.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO patientDTO) {
        Patient newPatient = new Patient();
        newPatient.setName(patientDTO.getName());
        newPatient.setAge(patientDTO.getAge());
        newPatient.setGender(patientDTO.getGender());
        newPatient.setInsuranceNumber(patientDTO.getInsuranceNumber());
        newPatient.setPhoneNumber(patientDTO.getPhoneNumber());
        newPatient.setMedicalHistory(patientDTO.getMedicalHistory());

        Patient savedPatient = patientRepository.save(newPatient);
        return ResponseEntity.created(URI.create("/patients/" + savedPatient.getPatientId())).body(savedPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setName(patientDTO.getName());
            patient.setAge(patientDTO.getAge());
            patient.setGender(patientDTO.getGender());
            patient.setInsuranceNumber(patientDTO.getInsuranceNumber());
            patient.setPhoneNumber(patientDTO.getPhoneNumber());
            patient.setMedicalHistory(patientDTO.getMedicalHistory());

            Patient updatedPatient = patientRepository.save(patient);
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
