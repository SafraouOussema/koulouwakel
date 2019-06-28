package com.koulwakel.koul.repository;

import com.koulwakel.koul.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    @RestResource(path = "/connexion")
    public List<Utilisateur> findByEmailContains(@Param("email") String email );



}
