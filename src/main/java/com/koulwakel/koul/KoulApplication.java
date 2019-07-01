package com.koulwakel.koul;

import com.koulwakel.koul.Web.WebImage;
import com.koulwakel.koul.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class KoulApplication  implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository ;

    public static void main(String[] args) {
        new File(WebImage.uploadDirectory).mkdir();
        SpringApplication.run(KoulApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        //categoryRepository.save(new Category(1,"Legume"));
    }
}
