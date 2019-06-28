package com.koulwakel.koul.repository;

import com.koulwakel.koul.Entites.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

    public List<Ingredient> findIngredientByCategoryTypeContaining(@Param("typ") String typ);
}
