package com.service.patient.service;

import com.service.patient.entity.Patient;
import com.service.patient.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicePatient implements IServicePatient{

    private PatientRepository patientRepository;
    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
