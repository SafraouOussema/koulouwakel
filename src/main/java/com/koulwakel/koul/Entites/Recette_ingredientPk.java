package com.koulwakel.koul.Entites;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor  @AllArgsConstructor
public class Recette_ingredientPk  implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade=CascadeType.ALL)
    @JoinColumn(name = "recette_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Recette recette ;

    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade= CascadeType.ALL)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Ingredient ingredient ;

    private String unitedemesure ;

    private float quantite;
}
