package org.sid.ouzane_amine_control1.service;

import org.sid.ouzane_amine_control1.entities.Livre;
import org.sid.ouzane_amine_control1.repositories.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;


    public List<Livre> getAllLivre(){
        return livreRepository.findAll();
    }

    public Livre addLivre(Livre livre){
        return livreRepository.save(livre);
    }

    public Livre livreById(Long id){
        return livreRepository.findById(id).orElse(null);
    }

    public boolean deleteLivre(Long id){
        livreRepository.deleteById(id);
        System.out.println("Livre a ete supprimer");
        return true;
    }

    public Livre updateLivre(Long id, Livre.LivreDTO livre){
        Livre livre1 = livreRepository.findById(id).orElse(null);
        if(livre1 != null){
            livre1.setPrix(livre1.getPrix());
            livre1.setTitre(livre1.getTitre());
            livre1.setAuteur(livre1.getAuteur());
        }
        return livreRepository.save(livre1);
    }
}
