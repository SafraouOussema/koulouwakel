package com.koulwakel.koul.Web;


import com.koulwakel.koul.Entites.Frigo;
import com.koulwakel.koul.Entites.FrigoPk;
import com.koulwakel.koul.repository.FrigoRepository;
import com.koulwakel.koul.repository.IngredientRepository;
import com.koulwakel.koul.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebFrigo {

    @Autowired
    FrigoRepository frigoRepository ;

    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    IngredientRepository ingredientRepository ;


    @RequestMapping(value="/affecter_frigo/{idingredient}/{idutilisateur}", method= RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Frigo saveFrigo (@PathVariable(value="idingredient")Integer idingredient , @PathVariable (value="idutilisateur")Integer idutilisateur
            , @RequestBody FrigoPk pp) {

        Frigo frigo = new Frigo();
        pp.setIngredient(ingredientRepository.findById(idingredient).get());
        pp.setUtilisateur(utilisateurRepository.findById(idutilisateur).get());

        frigo.setFrigoPk(pp);
        return frigoRepository.save(frigo);
    }





    @RequestMapping(value="/find_all_frigo" , method=RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")

    public List<Frigo> findProfGroupClass (){
        return frigoRepository.findAll();
    }



    @RequestMapping (value="/deletfrigo/{idingredient}/{idutilisateur}", method=RequestMethod.GET)
     @CrossOrigin(origins = "http://localhost:4200")
    public void deleteProfGroupClas (@PathVariable(value="idingredient")Integer idingredient , @PathVariable (value="idutilisateur")Integer idutilisateur, @RequestBody FrigoPk pp ) {
        frigoRepository.delete(new Frigo
                (new FrigoPk(ingredientRepository.findById(idingredient).get(),
                        utilisateurRepository.findById(idutilisateur).get(),pp.getUtilisabilite())));
    }


}
