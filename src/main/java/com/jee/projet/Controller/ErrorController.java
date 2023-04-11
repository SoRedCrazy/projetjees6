package com.jee.projet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ErrorController {

    @Autowired
    public ErrorController() {
    }

    @GetMapping(path = "/error")
    public String error(){
        return "error";
    }

}