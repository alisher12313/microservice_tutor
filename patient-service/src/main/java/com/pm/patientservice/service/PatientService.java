package com.pm.patientservice.service;

import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.PersonWasNotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.dto.PatientRequestDto;
import com.pm.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientRequestDto> getPatients(){
        List<Patient> list = patientRepository.findAll();
        List<PatientRequestDto> list1 = list.stream().map(PatientMapper::toDTO).toList();

        return list1;
    }

    public PatientRequestDto create(PatientRequestDto dto){
        if(patientRepository.existsByEmail(dto.getEmail())){
            throw new EmailAlreadyExistsException("Email " + dto.getEmail() + " already exists");
        }

        Patient patient = patientRepository.save(PatientMapper.toEntity(dto));
        return PatientMapper.toDTO(patient);
    }

    public PatientRequestDto update(UUID uuid, PatientRequestDto dto){
        Patient patient = patientRepository.findById(uuid).orElseThrow(() ->
                new PersonWasNotFoundException("Person was not found"));

        if(patientRepository.existsByEmailAndIdNot(dto.getEmail(), uuid)){
            throw new EmailAlreadyExistsException("Email " + dto.getEmail() + " already exists");
        }

        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setAddress(dto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));

        patientRepository.save(patient);
        return dto;
    }

    public void deletePatient(UUID id){
        patientRepository.deleteById(id);
    }
}
