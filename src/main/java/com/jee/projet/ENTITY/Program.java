package com.jee.projet.ENTITY;

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

    private float moyenne;

    @OneToMany
    private List<Activity> activities ;

    public Program(Long id, String titre, String description, float moyenne, List<Activity> activities) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.moyenne = moyenne;
        this.activities = activities;
    }

    public Program(String titre, String description, float moyenne, List<Activity> activities) {
        this.titre = titre;
        this.description = description;
        this.moyenne = moyenne;
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

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
