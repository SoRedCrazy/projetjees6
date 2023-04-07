package com.jee.projet.Controller;

import com.jee.projet.DAO.UserRepository;
import com.jee.projet.ENTITY.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConnexionController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping(path = "/connexion")
    public String Connection(){
        return "connexion";
    }

    @GetMapping(path = "/inscription")
    public String Inscription(){
        return "inscription";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getMotDePasse());
        user.setMotDePasse(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }
}
