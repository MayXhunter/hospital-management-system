package com.assignment1.managementSystem.controller;

import com.assignment1.managementSystem.dto.ReceptionistDTO;
import com.assignment1.managementSystem.entity.Receptionist;
import com.assignment1.managementSystem.repository.ReceptionistRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receptionists")
public class ReceptionistController {
    private final ReceptionistRepository receptionistRepository;

    public ReceptionistController(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    @GetMapping
    public List<Receptionist> getAllReceptionists() {
        return receptionistRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receptionist> getReceptionistById(@PathVariable Long id) {
        Optional<Receptionist> optionalReceptionist = receptionistRepository.findById(id);
        return optionalReceptionist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Receptionist> createReceptionist(@RequestBody ReceptionistDTO receptionistDTO) {
        Receptionist newReceptionist = new Receptionist();
        newReceptionist.setName(receptionistDTO.getName());

        Receptionist savedReceptionist = receptionistRepository.save(newReceptionist);
        return ResponseEntity.created(URI.create("/receptionists/" + savedReceptionist.getEmployeeId()))
                .body(savedReceptionist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receptionist> updateReceptionist(@PathVariable Long id,
                                                           @RequestBody ReceptionistDTO receptionistDTO) {
        Optional<Receptionist> optionalReceptionist = receptionistRepository.findById(id);
        if (optionalReceptionist.isPresent()) {
            Receptionist receptionist = optionalReceptionist.get();
            receptionist.setName(receptionistDTO.getName());

            Receptionist updatedReceptionist = receptionistRepository.save(receptionist);
            return ResponseEntity.ok(updatedReceptionist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceptionist(@PathVariable Long id) {
        if (receptionistRepository.existsById(id)) {
            receptionistRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

