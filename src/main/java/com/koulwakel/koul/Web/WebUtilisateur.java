package com.koulwakel.koul.Web;


import java.util.List;
import java.util.Optional;

import com.koulwakel.koul.Entites.Utilisateur;
import com.koulwakel.koul.repository.CategoryRepository;
import com.koulwakel.koul.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebUtilisateur {


    @Autowired
    UtilisateurRepository utilisateurRepository ;

    @RequestMapping(value = "/save_utilisateur",method= RequestMethod.POST , produces="application/json" )
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Utilisateur saveUtilisateur(@RequestBody Utilisateur c) {


        return utilisateurRepository.save(c);
    }



    @RequestMapping(value = "/find_utilisateur")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Utilisateur> findAllUtilisateur() {

        return utilisateurRepository.findAll();
    }

    @RequestMapping(value = "/find_utilisateur_id/{idutilisateur}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Utilisateur> findcategoryId(@PathVariable(value = "idutilisateur") Integer idutilisateur) {
        return utilisateurRepository.findById(idutilisateur);
    }





    @RequestMapping(value="/delete_utilisateur" , method=RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public int DeletUtilisateur(@RequestBody  Utilisateur c) {



        utilisateurRepository.delete(c);

        return 0;
    }

}
