package com.koulwakel.koul.Web;

import java.util.List;


import com.koulwakel.koul.Entites.Ingredient;
import com.koulwakel.koul.repository.CategoryRepository;
import com.koulwakel.koul.repository.ImageRepository;
import com.koulwakel.koul.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebIngredient {

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    CategoryRepository categoryRepository ;


    @RequestMapping(value = "/affecter_ingredient/{idcategory}/{idimge}", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Ingredient saveingredient(@PathVariable(value = "idcategory") Integer idcategory,
                                             @PathVariable(value = "idimge") Integer idimge
            , @RequestBody Ingredient ingredient) {

        ingredient.setCategory(categoryRepository.findById(idcategory).get());
        ingredient.setImage(imageRepository.findById(idimge).get());
        return ingredientRepository.save(ingredient);
    }

    @RequestMapping(value="/find_all_ingredient",method=RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Ingredient> findAllingredient (){
        return ingredientRepository.findAll();
    }

    @RequestMapping(value = "/find_ingredient_name/{type}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Ingredient> findcategoryname(@PathVariable(value = "type") String type) {
        return ingredientRepository.findIngredientByCategoryTypeContaining(type);
    }





}
