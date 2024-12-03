package com.service.med.controller;


import com.service.med.entity.Medecin;
import com.service.med.service.IServiceMedecin;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medecin/")
@AllArgsConstructor
public class MedecinRestController {

    private IServiceMedecin iServiceMedecin;

    @PostMapping("add")
    public Medecin add(@RequestBody Medecin medecin){
        return iServiceMedecin.addMedecin(medecin);
    }

    @GetMapping("all")
    public List<Medecin> allMedecins(){
        return iServiceMedecin.getAllMedecins();
    }
}
