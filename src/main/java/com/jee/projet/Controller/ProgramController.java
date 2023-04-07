package com.jee.projet.Controller;

import com.jee.projet.ENTITY.Program;
import com.jee.projet.ENTITY.User;
import com.jee.projet.Services.ProgramService;
import com.jee.projet.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProgramController {

    private final ProgramService progamService;
    private final UserService userService;
    @Autowired
    public ProgramController(ProgramService progamService, UserService userService) {
        this.progamService = progamService;
        this.userService = userService;
    }

    @GetMapping(path = "/{programId}")
    public float getStudents(@PathVariable("programId") long id){
        Program p= progamService.getById(id);
        return progamService.getMoyennne(p);
    }
    @GetMapping(path = "/home")
    public String Home(Model model) {
        User user = userService.getUserById(21);
        List<Program> programs = user.getPrograms();
        model.addAttribute("User", user);
        return "home";
    }

}