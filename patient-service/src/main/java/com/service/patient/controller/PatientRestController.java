package com.service.patient.controller;


import com.service.patient.entity.Patient;
import com.service.patient.service.IServicePatient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient/")
@AllArgsConstructor
public class PatientRestController {

    private IServicePatient iServicePatient;

    @PostMapping("add")
    public Patient add(@RequestBody Patient patient){
        return iServicePatient.addPatient(patient);
    }

    @GetMapping("all")
    public List<Patient> allPatients(){
        return iServicePatient.getAllPatients();
    }


}
