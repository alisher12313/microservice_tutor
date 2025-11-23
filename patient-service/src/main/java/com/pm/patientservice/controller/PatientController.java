package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDto;
import com.pm.patientservice.dto.validators.CreationGroup;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "/patients")
@RequiredArgsConstructor
@Tag(name = "Patient", description = "API for managing patients")
public class PatientController {
    private final PatientService service;

    @GetMapping(path = "/getAll")
    @Operation(summary = "Get all patients")
    public ResponseEntity<?> getAllPatients(){
        List<PatientRequestDto> responseDtos = service.getPatients();
        return ResponseEntity.ok(responseDtos);
    }

    @PostMapping("/create")
    @Operation(summary = "Create a patient")
    public ResponseEntity<?> createPatient(@Validated({Default.class, CreationGroup.class}) @RequestBody PatientRequestDto dto){
        PatientRequestDto dto1 = service.create(dto);
        return ResponseEntity.ok(dto1);
    }

    @PutMapping("/update")
    @Operation(summary = "Update patient by uuid")
    public ResponseEntity<?> updatePatient(@RequestParam UUID id, @Validated({Default.class}) @RequestBody PatientRequestDto dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete patient by uuid")
    public ResponseEntity<?> deletePatient(@RequestParam UUID id){
        service.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("message", "successfully deleted"));
    }
}
