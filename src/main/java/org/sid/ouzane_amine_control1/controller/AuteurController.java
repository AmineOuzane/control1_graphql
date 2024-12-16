package org.sid.ouzane_amine_control1.controller;

import org.sid.ouzane_amine_control1.entities.Auteur;
import org.sid.ouzane_amine_control1.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuteurController {
    @Autowired
    private AuteurService auteurService;

    @QueryMapping
    public List<Auteur> getAllAuteurs(){
        return auteurService.getAllAuteurs();
    }
}
