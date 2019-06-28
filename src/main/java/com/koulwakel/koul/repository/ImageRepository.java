package com.koulwakel.koul.repository;

import com.koulwakel.koul.Entites.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ImageRepository extends JpaRepository<Image,Integer> {

    @RestResource(path = "/bylabelle")
    public List<Image> findByLabelleContains(@Param("labelle") String labelle);



}
