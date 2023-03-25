package com.jee.projet.ENTITY;

import javax.persistence.*;

@Entity
@Table
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @Transient
    private int moyenne;

    public Activity(Long id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    public Activity() {
    }

    public Activity(String titre, String description) {
        this.titre = titre;
        this.description = description;
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

    public int getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(int moyenne) {
        this.moyenne = moyenne;
    }
}
