package com.koulwakel.koul.Web;


import java.util.List;
import java.util.Optional;

import com.koulwakel.koul.Entites.Recette;
import com.koulwakel.koul.repository.EtapeRpository;
import com.koulwakel.koul.repository.ImageRepository;
import com.koulwakel.koul.repository.RecetteRepository;
import com.koulwakel.koul.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebRecette {

    @Autowired
    EtapeRpository etapeRpository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    RecetteRepository recetteRepository ;
    @Autowired
    UtilisateurRepository utilisateurRepository;


    @RequestMapping(value = "/add_recette/{idetape}/{idimge}/{idutilisateur}", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Recette saveingredient(@PathVariable(value = "idetape") Integer idetape,
                                  @PathVariable(value = "idimge") Integer idimge,
                                  @PathVariable(value = "idutilisateur") Integer idutilisateur
            , @RequestBody Recette recette) {

        recette.setEtape(etapeRpository.findById(idetape).get());
        recette.setImage(imageRepository.findById(idimge).get());
        recette.setUtilisateur(utilisateurRepository.findById(idutilisateur).get());
        return recetteRepository.save(recette);
    }

    @RequestMapping(value="/find_all_recett",method=RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Recette> findAllrecett (){

        return recetteRepository.findAll();
    }


    @RequestMapping(value="/delete_recette" , method=RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public int Deletrecett(@RequestBody  Recette n) {



        recetteRepository.delete(n);

        return 0;
    }

}
