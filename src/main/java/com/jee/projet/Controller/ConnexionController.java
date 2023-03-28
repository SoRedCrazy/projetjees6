package com.jee.projet.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnexionController {


    @GetMapping(path = "/connexion")
    public String Connection(){
        return "connexion";
    }

    @GetMapping(path = "/inscription")
    public String Inscription(){
        return "inscription";
    }
}
