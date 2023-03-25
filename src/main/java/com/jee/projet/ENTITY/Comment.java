package com.jee.projet.ENTITY;

import javax.persistence.*;
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private int note;

    @ManyToOne
    private User user;
    @ManyToOne
    private Activity activity;

    public Comment(Long id, String titre, String description, int note, User user, Activity activity) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.note = note;
        this.user = user;
        this.activity = activity;
    }

    public Comment(String titre, String description, int note, User user, Activity activity) {
        this.titre = titre;
        this.description = description;
        this.note = note;
        this.user = user;
        this.activity = activity;
    }

    public Comment() {
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

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
