package com.jee.projet.Services;

import com.jee.projet.DAO.CommentRepository;
import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Comment;
import com.jee.projet.ENTITY.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }

    public List<Comment> getComments(Activity activity, User user){return commentRepository.findCommentByActivityAndUser(activity,user); }

    public void addservice(String titre, String description, String note, User user, Activity a) {

        commentRepository.save(new Comment(titre,description,Integer.parseInt(note),user,a));
    }
}
