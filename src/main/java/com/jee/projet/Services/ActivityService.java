package com.jee.projet.Services;

import com.jee.projet.DAO.ActivityRepository;
import com.jee.projet.DAO.CommentRepository;
import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Comment;
import com.jee.projet.ENTITY.Program;
import com.jee.projet.ENTITY.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;
    private CommentRepository commentRepository;

    @Autowired
    public ActivityService(CommentRepository commentRepository,ActivityRepository activityRepository) {
        this.activityRepository =activityRepository;
        this.commentRepository = commentRepository;
    }

    public Double getMoyennne(Activity activity, User user){
        List<Comment> cm = commentRepository.findCommentByActivityAndUser(activity,user);
        float moyenne = 0;
        if(cm != null && !cm.isEmpty()) {
            for(Comment comment: cm){
                moyenne+=comment.getNote();
            }
            moyenne= moyenne/cm.size();
        }
        return Math.round(moyenne * Math.pow(10,1)) / Math.pow(10,1);
    }

    public Activity getById(long id) {
        return activityRepository.getById(id);
    }

    public List<Activity> findall() {
        return activityRepository.findAll();
    }
}
