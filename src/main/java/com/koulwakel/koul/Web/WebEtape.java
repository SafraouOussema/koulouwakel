package com.koulwakel.koul.Web;


import com.koulwakel.koul.Entites.Etape;
import com.koulwakel.koul.repository.EtapeRpository;
import com.koulwakel.koul.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebEtape {

    @Autowired
    EtapeRpository etapeRpository ;

    @Autowired
    ImageRepository imageRepository;

    @RequestMapping(value = "/add_etape/{idimge}", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Etape saveetape(@PathVariable(value = "idimge") Integer idimge , @RequestBody Etape ingredient) {


        ingredient.setImage(imageRepository.findById(idimge).get());
        return etapeRpository.save(ingredient);
    }


    @RequestMapping(value = "/find_etape")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Etape> findAlletape() {

        return etapeRpository.findAll();
    }

    @RequestMapping(value="/delete_etape" , method=RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public int Deletetape(@RequestBody  Etape c) {



        etapeRpository.delete(c);

        return 0;
    }



}
