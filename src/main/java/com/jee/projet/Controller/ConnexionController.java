package com.jee.projet.Controller;

import com.jee.projet.ENTITY.User;
import com.jee.projet.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConnexionController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/connexion")
    public String Connection(){
        return "connexion";
    }

    @PostMapping(path = "/connexion")
    public String Connection(Model model,String email,String password){
        User u = userService.getUserByMail(email);

        if(u.getMotDePasse().equals(password)){
            model.addAttribute("User", u);
            return "home";
        }else {
            return  "connexion";
        }
    }

    @GetMapping("/inscription")
    public String register(Model model){
        return "inscription";
    }

    @PostMapping("/inscription")
    public String registerUserAccount(String nom, String prenom, String pseudo, String email, String adresse, String password, String tel){
        userService.addUser(nom,prenom,pseudo,email,adresse,password,tel);
        return "connexion";
    }
}
