package com.koulwakel.koul.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Recette implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;


    private String nom ;

    private int preparation ;

    private int nbpersonne ;

    private String difficulte ;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image ;

    @ManyToOne
    @JoinColumn(name = "etape_id")
    private Etape etape ;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur ;


}