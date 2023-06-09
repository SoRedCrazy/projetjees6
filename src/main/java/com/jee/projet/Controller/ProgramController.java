package com.jee.projet.Controller;

import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Program;
import com.jee.projet.ENTITY.User;
import com.jee.projet.Services.ActivityService;
import com.jee.projet.Services.ProgramService;
import com.jee.projet.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String programme(@PathVariable("programId") long idprog,Model model, HttpServletRequest request){
        String s= request.getSession().getAttribute("id").toString();
        int id =Integer.parseInt(s);
        User user = userService.getUserById(id);
        Program p= progamService.getById(idprog);
        model.addAttribute("programme",p);
        double i=progamService.getMoyennne(p,user);
        model.addAttribute("moyenne",i);
        return "programme";
    }
    @GetMapping(path = "/home")
    public String Home(Model model, HttpServletRequest request) {
        String s= request.getSession().getAttribute("id").toString();
        int id =Integer.parseInt(s);
        User user = userService.getUserById(id);
        List<Program> programs = user.getPrograms();
        model.addAttribute("User", user);
        return "home";
    }


    @GetMapping(path = "/add")
    public  String addform(Model model){
        List<Activity> activityList = activityService.findall();
        model.addAttribute("activitiess", activityList);
        model.addAttribute("program", new Program());
        return "addprogramme";
    }

    @PostMapping (path = "/add")
    public  String backform(Model model, @ModelAttribute("Program") Program program, HttpServletRequest request){
        progamService.save(program);

        String s= request.getSession().getAttribute("id").toString();
        int id =Integer.parseInt(s);
        User user = userService.getUserById(id);

        List<Program> programList = user.getPrograms();
        programList.add(program);
        user.setPrograms(programList);
        userService.save(user);
        model.addAttribute("User", user);
        return "home";


    }

    @ModelAttribute(value = "program")
    public Program newEntity()
    {
        return new Program();
    }




}