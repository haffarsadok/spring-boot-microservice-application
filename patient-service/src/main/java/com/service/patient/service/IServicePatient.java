package com.service.patient.service;

import com.service.patient.entity.Patient;

import java.util.List;

public interface IServicePatient {

    public Patient addPatient(Patient patient);
    public List<Patient> getAllPatients();
}
