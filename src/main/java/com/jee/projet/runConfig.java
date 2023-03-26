package com.jee.projet;

import com.jee.projet.DAO.ActivityRepository;
import com.jee.projet.DAO.CommentRepository;
import com.jee.projet.DAO.ProgramRepository;
import com.jee.projet.DAO.UserRepository;
import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Comment;
import com.jee.projet.ENTITY.Program;
import com.jee.projet.ENTITY.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class runConfig implements CommandLineRunner  {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public void run(String... args) {

        ArrayList<Activity> listActivity = new ArrayList<Activity>();

        listActivity.add(new Activity("run30", "courir pendant 30 min"));
        listActivity.add(new Activity("repos", "5 mins de repos en marchant"));
        listActivity.add(new Activity("run15", "courir pendant 15 min"));
        activityRepository.saveAll(listActivity);


        Program program = new Program("progamme de sprinte","progame contenant plusieur exercie de sprint", listActivity);
        programRepository.save(program);
        ArrayList<Program> listProgram = new ArrayList<Program>();

        listProgram.add(program);
        User  user = new User("Didier93", "Didierlebg", "Lafougere", "Didier" ,"15 allé des accasia 37190 azay le rideau", "Didiersport@gmail.com" , "0604186555", listProgram);

        userRepository.save(user);

        Comment cm1  =new Comment("bonne activité", "super bien pour les molé je recommande", 5, user, listActivity.get(1));
        Comment cm2 =new Comment("bonne activité", "super bien pour les molé je recommande", 2, user, listActivity.get(1));
        Comment cm3  =new Comment("bonne activité", "super bien pour les molé je recommande", 1, user, listActivity.get(2));
        Comment cm4 =new Comment("bonne activité", "super bien pour les molé je recommande", 4, user, listActivity.get(2));
        commentRepository.saveAll(
                List.of(cm1,cm2,cm3,cm4)
        );
        System.out.println("Moyenne de l'activité 2 :"+ listActivity.get(2).getMoyenne(commentRepository));
        System.out.println("Programme moyenne : "+program.getMoyenne(commentRepository));
    }

}
