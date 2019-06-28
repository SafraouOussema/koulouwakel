package com.koulwakel.koul.repository;

import com.koulwakel.koul.Entites.Etape;
import com.koulwakel.koul.Entites.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface EtapeRpository extends JpaRepository<Etape,Integer> {


    public List<Etape> findByImage (Image i );

}
