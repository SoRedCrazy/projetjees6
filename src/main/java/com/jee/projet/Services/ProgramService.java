package com.jee.projet.Services;

import com.jee.projet.DAO.ProgramRepository;
import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Program;
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

    public float getMoyennne(Program pr){
        List<Activity> activities = pr.getActivities();
        float moyenne = 0;
        if(activities != null && !activities.isEmpty()) {
            for(Activity ac: activities){
                moyenne+=activityService.getMoyennne(ac);
            }
            moyenne= moyenne/activities.size();
        }
        return moyenne;
    }

    public Program getById(long id) {
        return programRepository.getById(id);
    }
}
