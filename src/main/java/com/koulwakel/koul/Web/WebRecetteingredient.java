package com.koulwakel.koul.Web;


import java.util.List;
import java.util.Optional;

import com.koulwakel.koul.Entites.Recette_ingredient;
import com.koulwakel.koul.Entites.Recette_ingredientPk;
import com.koulwakel.koul.repository.IngredientRepository;
import com.koulwakel.koul.repository.RecetteRepository;
import com.koulwakel.koul.repository.Recette_ingredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebRecetteingredient {


    @Autowired
    Recette_ingredientRepository recetteIngredientRepository ;

    @Autowired
    RecetteRepository recetteRepository;
    @Autowired
    IngredientRepository ingredientRepository ;


    @RequestMapping(value="/affecter_frigo/{idingredient}/{idrecette}", method= RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Recette_ingredient saveFrigo (@PathVariable(value="idingredient")Integer idingredient , @PathVariable (value="idrecette")Integer idrecette
            , @RequestBody Recette_ingredientPk pp) {

        Recette_ingredient recette = new Recette_ingredient();
        pp.setIngredient(ingredientRepository.findById(idingredient).get());
        pp.setRecette(recetteRepository.findById(idrecette).get());

        recette.setRecette_ingredientPk(pp);
        return recetteIngredientRepository.save(recette);
    }





    @RequestMapping(value="/find_all_recetteingredient" , method=RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Recette_ingredient> findrecetteingredient (){
        return recetteIngredientRepository.findAll();
    }



    @RequestMapping (value="/deletfrigo/{idingredient}/{idrecette}", method=RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteProfGroupClas (@PathVariable(value="idingredient")Integer idingredient , @PathVariable (value="idrecette")Integer idrecette, @RequestBody Recette_ingredientPk pp ) {

        recetteIngredientRepository.delete(new Recette_ingredient
                (new Recette_ingredientPk(recetteRepository.findById(idrecette).get() ,ingredientRepository.findById(idingredient).get()
                        ,pp.getUnitedemesure(),pp.getQuantite())));
    }



}
