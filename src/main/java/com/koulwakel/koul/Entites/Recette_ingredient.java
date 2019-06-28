package com.koulwakel.koul.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recette_ingredient {

    @EmbeddedId
    protected Recette_ingredientPk recette_ingredientPk ;
}
