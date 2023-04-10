package com.jee.projet.Controller;

import com.jee.projet.ENTITY.Program;
import com.jee.projet.ENTITY.User;
import com.jee.projet.Services.ActivityService;
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
    private final ActivityService activityService;
    @Autowired
    public ProgramController(ProgramService progamService, UserService userService, ActivityService activityService) {
        this.progamService = progamService;
        this.userService = userService;
        this.activityService= activityService;
    }

    @GetMapping(path = "/programme/{programId}")
    public String programme(@PathVariable("programId") long id,Model model){
        User user = userService.getUserById(21);
        Program p= progamService.getById(id);
        model.addAttribute("programme",p);
        double i=progamService.getMoyennne(p,user);
        model.addAttribute("moyenne",i);
        return "programme";
    }
    @GetMapping(path = "/home")
    public String Home(Model model) {
        User user = userService.getUserById(21);
        List<Program> programs = user.getPrograms();
        model.addAttribute("User", user);
        return "home";
    }




}