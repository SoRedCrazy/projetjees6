package com.jee.projet.Controller;

import com.jee.projet.ENTITY.Program;
import com.jee.projet.Services.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ProgramController {

    private final ProgramService progamService;
    @Autowired
    public ProgramController(ProgramService progamService) {
        this.progamService = progamService;
    }

    @GetMapping(path = "{programId}")
    public float getStudents(@PathVariable("programId") long id){
        Program p= progamService.getById(id);
        return progamService.getMoyennne(p);
    }

}