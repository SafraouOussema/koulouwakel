package com.koulwakel.koul.repository;

import com.koulwakel.koul.Entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface CategoryRepository  extends JpaRepository<Category,Integer> {

        @RestResource(path = "/catigorybyType")
        public List<Category> findByTypeContains(@Param("typ") String typ);



}
//http://localhost:8088/categories/search/byType?typ=Po