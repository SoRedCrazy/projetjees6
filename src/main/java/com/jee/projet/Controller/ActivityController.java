package com.jee.projet.Controller;


import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Comment;
import com.jee.projet.ENTITY.Program;
import com.jee.projet.ENTITY.User;
import com.jee.projet.Services.ActivityService;
import com.jee.projet.Services.CommentService;
import com.jee.projet.Services.ProgramService;
import com.jee.projet.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ActivityController {

    private final ActivityService activityService;
    private final CommentService commentService;
    private final UserService userService;
    @Autowired
    public ActivityController(CommentService commentService, ActivityService activityService,UserService userService) {
        this.activityService = activityService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping(path = "/activity/{activityId}")
    public String comments(@PathVariable("activityId") long id, Model model, HttpServletRequest request){
        String s= request.getSession().getAttribute("id").toString();
        int iduser =Integer.parseInt(s);
        User user = userService.getUserById(iduser);
        Activity a= activityService.getById(id);
        model.addAttribute("Activity",a);

        List<Comment> commentList = commentService.getComments(a,user);
        model.addAttribute("comments", commentList);
        Double i=activityService.getMoyennne(a,user);
        model.addAttribute("moyenne",i);
        return "activity";
    }

    @PostMapping (path = "/activity/{activityId}")
    public String adcomments(@PathVariable("activityId") long id, Model model, String titre, String description, String note, HttpServletRequest request){
        String s= request.getSession().getAttribute("id").toString();
        int iduser =Integer.parseInt(s);
        User user = userService.getUserById(iduser);
        Activity a= activityService.getById(id);
        commentService.addservice(titre,description,note,user,a);
        model.addAttribute("Activity",a);
        List<Comment> commentList = commentService.getComments(a,user);
        model.addAttribute("comments", commentList);
        Double i=activityService.getMoyennne(a,user);
        model.addAttribute("moyenne",i);
        return "activity";
    }
}
