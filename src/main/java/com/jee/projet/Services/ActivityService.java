package com.jee.projet.Services;

import com.jee.projet.DAO.ActivityRepository;
import com.jee.projet.DAO.CommentRepository;
import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Comment;
import com.jee.projet.ENTITY.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    private CommentRepository commentRepository;

    @Autowired
    public ActivityService(CommentRepository commentRepository) {

        this.commentRepository = commentRepository;
    }

    public float getMoyennne(Activity activity){
        List<Comment> cm = commentRepository.findCommentByActivity(activity);
        float moyenne = 0;
        if(cm != null && !cm.isEmpty()) {
            for(Comment comment: cm){
                moyenne+=comment.getNote();
            }
            moyenne= moyenne/cm.size();
        }
        return moyenne;
    }
}
