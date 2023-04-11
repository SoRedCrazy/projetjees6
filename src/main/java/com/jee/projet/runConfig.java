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
public class runConfig implements CommandLineRunner {
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

        listActivity.add(new Activity("Yoga 1", "Salutation au soleil (5 minutes)"));
        listActivity.add(new Activity("Yoga 2", "Torsion assise (2 minutes)"));
        listActivity.add(new Activity("Yoga 3", "Etirement des ischio-jambiers (2 minutes)"));
        listActivity.add(new Activity("Yoga 4", "Position de la planche (1 minute)"));
        listActivity.add(new Activity("Yoga 5", "Flexion avant (2 minutes)"));
        listActivity.add(new Activity("Yoga 6", "Position du cobra (2 minutes)"));
        listActivity.add(new Activity("Yoga 7", "Relaxation (5 minutes)"));
        
        listActivity.add(new Activity("Marche 1", "Echauffement (5 minutes)"));
        listActivity.add(new Activity("Marche 2", "Marche rapide (20 minutes)"));
        listActivity.add(new Activity("Marche 3", "Marche lente, reprise (5 minutes)"));

        listActivity.add(new Activity("Course 1", "Pas chassés (5 minutes)"));
        listActivity.add(new Activity("Course 2", "Talons-fesses (1 minute)"));
        listActivity.add(new Activity("Course 3", "Course lente (30 minutes)"));
        listActivity.add(new Activity("Course 4", "Course 120% (15 minutes)"));
        listActivity.add(new Activity("Course 5", "Course sur 1km"));
        listActivity.add(new Activity("Course 6", "Course sur 2km"));
        listActivity.add(new Activity("Course 7", "Course sur 5km"));
        listActivity.add(new Activity("Course 8", "Course sur 10km"));

        listActivity.add(new Activity("Méditation 1", "Assis, yeux fermés, se concentrer sur sa respiration (tranches de 10 minutes)"));
        listActivity.add(new Activity("Méditation 2", "Compter les moutons jusqu'à 100, sans dépasser 1 mouton par seconde"));

        listActivity.add(new Activity("Danse 1", "Echauffement des jambes et mollets (5 minutes)"));
        listActivity.add(new Activity("Danse 2", "Echauffement des bras et des mains (5 minutes)"));
        listActivity.add(new Activity("Danse 3", "Salsa sur 3 musiques (10 minutes)"));
        listActivity.add(new Activity("Danse 4", "Tango sur 3 musiques (10 minutes)"));
        listActivity.add(new Activity("Danse 5", "Valse sur 3 musiques (10 minutes)"));

        listActivity.add(new Activity("Natation 1", "Grenouille sur 10 longueurs (aller-retour)"));
        listActivity.add(new Activity("Natation 2", "Crawl sur 10 longueurs (aller-retour)"));
        listActivity.add(new Activity("Natation 3", "25 longueurs avec la nage au choix"));
        listActivity.add(new Activity("Natation 4", "Grenouilles sous l'eau sur 10 longueurs"));

        listActivity.add(new Activity("Musculation 1", "Squat: 3x12 répétitions"));
        listActivity.add(new Activity("Musculation 2", "Développé couché: 3x10 répétitions"));
        listActivity.add(new Activity("Musculation 3","Soulevé de terre: 3x8 répétitions"));
        listActivity.add(new Activity("Musculation 4","Curl biceps: 3x12 répétitions"));
        listActivity.add(new Activity("Musculation 5","Extensions triceps: 3x10 répétitions"));

        listActivity.add(new Activity("Ecriture 1", "Ecrire un poème en 10 minutes"));
        listActivity.add(new Activity("Ecriture 2", "Ecrire une histoire avec une chute en 20 minutes"));
        listActivity.add(new Activity("Ecriture 3", "Ecrire son dernier rêve en 10 minutes"));
        activityRepository.saveAll(listActivity);

    }
}