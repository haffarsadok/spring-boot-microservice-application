package com.service.med.service;

import com.service.med.entity.Medecin;

import java.util.List;

public interface IServiceMedecin {

    public Medecin addMedecin(Medecin medecin);
    public List<Medecin> getAllMedecins();
}
