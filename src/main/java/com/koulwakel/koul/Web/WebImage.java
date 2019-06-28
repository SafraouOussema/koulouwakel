package com.koulwakel.koul.Web;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.koulwakel.koul.Entites.Image;
import com.koulwakel.koul.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebImage {
    private static final Logger log = LoggerFactory.getLogger(WebImage.class);

    @Autowired
    ImageRepository imageRepository;


    @RequestMapping(value = "/save_image",method= RequestMethod.POST , produces="application/json" )
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Image save(@RequestBody Image n) {

        log.info("aaaaaaaaaaaaaaaaaaaaa"+n.getLabelle());

        return imageRepository.save(n);
    }




    @RequestMapping(value = "/find_image")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Image> findAllImage() {
        return imageRepository.findAll();
    }

    @RequestMapping(value = "/find_id_image/{idimage}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Image> findIdimage(@PathVariable(value = "idimage") Integer idimage) {
        return imageRepository.findById(idimage);
    }


    @RequestMapping(value="/image_delete" , method=RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public int DeletImage(@RequestBody Image n) {



        imageRepository.delete(n);

        return 0;
    }


}
