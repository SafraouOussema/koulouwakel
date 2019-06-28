package com.koulwakel.koul.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import javax.persistence.CascadeType;


@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class FrigoPk implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade=CascadeType.ALL)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Ingredient ingredient ;

    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade=CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Utilisateur utilisateur ;

    private int utilisabilite ;


}
