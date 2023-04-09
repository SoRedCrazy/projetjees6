package com.jee.projet.DAO;

import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Comment;
import com.jee.projet.ENTITY.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.activity =?1 AND c.user=?2")
    List<Comment> findCommentByActivityAndUser(Activity activity, User user);

}