package com.koulwakel.koul.repository;

import com.koulwakel.koul.Entites.Recette_ingredient;
import com.koulwakel.koul.Entites.Recette_ingredientPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Recette_ingredientRepository extends JpaRepository<Recette_ingredient, Recette_ingredientPk> {
}
