package com.koulwakel.koul.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;


    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image ;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;
}
