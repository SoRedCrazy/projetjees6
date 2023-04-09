package com.jee.projet.Controller;


import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Program;
import com.jee.projet.Services.ActivityService;
import com.jee.projet.Services.CommentService;
import com.jee.projet.Services.ProgramService;
import com.jee.projet.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ActivityController {

    private final ActivityService activityService;
    private final CommentService commentService;
    @Autowired
    public ActivityController(CommentService commentService, ActivityService activityService) {
        this.activityService = activityService;
        this.commentService = commentService;
    }

    @GetMapping(path = "/activity/{activityId}")
    public String programme(@PathVariable("activityId") long id, Model model){
        Activity a= activityService.getById(id);
        model.addAttribute("Activity",a);
        float i=activityService.getMoyennne(a);
        model.addAttribute("moyenne",i);
        return "activity";
    }
}
