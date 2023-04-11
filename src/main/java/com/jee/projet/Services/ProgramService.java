package com.jee.projet.Services;

import com.jee.projet.DAO.ProgramRepository;
import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Program;
import com.jee.projet.ENTITY.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    private ProgramRepository programRepository;
    private ActivityService activityService;

    @Autowired
    public ProgramService(ActivityService activityService,ProgramRepository programRepository) {
        this.activityService = activityService;
        this.programRepository= programRepository;
    }

    public double getMoyennne(Program pr, User user){
        List<Activity> activities = pr.getActivities();
        float moyenne = 0;
        if(activities != null && !activities.isEmpty()) {
            for(Activity ac: activities){
                moyenne+=activityService.getMoyennne(ac,user);
            }
            moyenne= moyenne/activities.size();
        }
        return Math.round(moyenne * Math.pow(10,1)) / Math.pow(10,1);
    }

    public Program getById(long id) {
        return programRepository.getById(id);
    }


    public void save(Program program) {
        programRepository.saveAndFlush(program);
    }
}
