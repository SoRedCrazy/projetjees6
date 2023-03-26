package com.jee.projet.ENTITY;

import com.jee.projet.DAO.CommentRepository;

import javax.persistence.*;
import java.util.List;
@Entity
@Table
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    @Transient
    private float moyenne;

    @OneToMany
    private List<Activity> activities ;

    public Program(Long id, String titre, String description, List<Activity> activities) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.activities = activities;
    }

    public Program(String titre, String description, List<Activity> activities) {
        this.titre = titre;
        this.description = description;
        this.activities = activities;
    }

    public Program() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getMoyenne(CommentRepository commentRepository) {
        float moyenne = 0;
        if(activities != null && !activities.isEmpty()) {
            for(Activity ac: activities){
                moyenne+=ac.getMoyenne(commentRepository);
            }
            this.moyenne= moyenne/activities.size();
        }
        return this.moyenne;
    }


    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
