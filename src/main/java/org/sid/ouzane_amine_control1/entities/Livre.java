package org.sid.ouzane_amine_control1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "auteurId")
    private Auteur auteur;

    public record LivreDTO(String titre, String auteur, Double prix) {
    }

}
