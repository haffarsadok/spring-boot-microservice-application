package com.service.med.service;

import com.service.med.entity.Medecin;
import com.service.med.repository.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceMedecin implements IServiceMedecin{

    private MedecinRepository medecinRepository;
    @Override
    public Medecin addMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }
    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }
}
