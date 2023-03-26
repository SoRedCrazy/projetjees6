package com.jee.projet.ENTITY;

import com.jee.projet.DAO.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @Transient
    private float moyenne;



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

    public float getMoyenne(CommentRepository commentRepository) {

        List<Comment> cm = commentRepository.findCommentByActivity(this);
        float moyenne = 0;
        if(cm != null && !cm.isEmpty()) {
            for(Comment comment: cm){
                moyenne+=comment.getNote();
            }
            this.moyenne= moyenne/cm.size();
        }
        return this.moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }
}
