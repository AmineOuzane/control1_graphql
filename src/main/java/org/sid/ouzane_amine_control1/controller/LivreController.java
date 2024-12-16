package org.sid.ouzane_amine_control1.controller;

import org.sid.ouzane_amine_control1.entities.Auteur;
import org.sid.ouzane_amine_control1.entities.Livre;
import org.sid.ouzane_amine_control1.repositories.LivreRepository;
import org.sid.ouzane_amine_control1.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;
    @Autowired
    private  LivreRepository livreRepository;

    @QueryMapping
    public List<Livre> getAllLivre() {
        return livreService.getAllLivre();
    }

    @QueryMapping
    public Livre livreById(@Argument Long id) {
        return livreService.livreById(id);
    }

    @MutationMapping
    public Livre addLivre (@Argument Livre.LivreDTO livre) {
        Livre livre1 = new Livre();
        livre1.setTitre(livre1.getTitre());
        livre1.setPrix(livre1.getPrix());
        livre1.setAuteur(livre1.getAuteur());
        return livreService.addLivre(livre1);
    }

    @MutationMapping
    public Livre updateLivre(@Argument Livre.LivreDTO livre, @Argument Long id){
        Livre updatedLivre = livreService.livreById(id);
        if (updatedLivre != null) {
            updatedLivre.setAuteur(updatedLivre.getAuteur());
            updatedLivre.setTitre(updatedLivre.getTitre());
            updatedLivre.setPrix(updatedLivre.getPrix());
        }
        return livreRepository.save(updatedLivre);
    }

    @MutationMapping
    public void deleteLivre(@Argument Long id){
        livreService.deleteLivre(id);
    }
}
