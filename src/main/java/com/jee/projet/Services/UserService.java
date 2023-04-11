package com.jee.projet.Services;

import com.jee.projet.DAO.UserRepository;
import com.jee.projet.ENTITY.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(String nom, String prenom, String pseudo, String email, String adresse, String password, String tel){
        userRepository.save(new User(pseudo,password,nom,prenom,adresse,email,tel));
    }

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User getUserById(long id) {
        return this.userRepository.getById(id);
    }

}
