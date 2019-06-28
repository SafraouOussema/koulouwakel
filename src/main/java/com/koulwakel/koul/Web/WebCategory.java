package com.koulwakel.koul.Web;

import java.util.List;
import java.util.Optional;

import com.koulwakel.koul.Entites.Category;
import com.koulwakel.koul.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebCategory {


    @Autowired
    CategoryRepository categoryRepository ;

   @RequestMapping(value = "/save_category",method= RequestMethod.POST , produces="application/json" )
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Category save(@RequestBody Category c) {


       return categoryRepository.save(c);
    }



    @RequestMapping(value = "/find_category")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Category> findAllcategory() {

        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/find_category_id/{idCategory}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Category> findcategoryId(@PathVariable(value = "idCategory") Integer idCategory) {
        return categoryRepository.findById(idCategory);
    }

    @RequestMapping(value = "/find_category_name/{idname}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Category> findcategoryname(@PathVariable(value = "idname") String idname) {
        return categoryRepository.findByTypeContains(idname);
    }




    @RequestMapping(value="/delete_category" , method=RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public int Deletcategory(@RequestBody  Category c) {



        categoryRepository.delete(c);

        return 0;
    }



}
