package com.koulwakel.koul.repository;

import com.koulwakel.koul.Entites.Recette;
import com.koulwakel.koul.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface RecetteRepository extends JpaRepository<Recette,Integer> {

    public List<Recette> findByUtilisateur (Utilisateur u );
}
