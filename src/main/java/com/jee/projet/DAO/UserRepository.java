package com.jee.projet.DAO;

import com.jee.projet.ENTITY.Activity;
import com.jee.projet.ENTITY.Comment;
import com.jee.projet.ENTITY.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u WHERE u.mail =?1")
    User findUserByMail(String mail);

}
