package org.sid.ouzane_amine_control1.service;

import org.sid.ouzane_amine_control1.entities.Auteur;
import org.sid.ouzane_amine_control1.repositories.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurService {
    @Autowired
    AuteurRepository auteurRepository;

    public List<Auteur> getAllAuteurs(){
        return auteurRepository.findAll();
    }
}
