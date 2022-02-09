package com.tutoratbackend.tutorat.services;

import com.tutoratbackend.tutorat.enumeration.Etat;
import com.tutoratbackend.tutorat.model.Users;
import com.tutoratbackend.tutorat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    //ajouter ls utilisateurs
    @Override
    public String addUsers(Users users) {
        users.setEtat(Etat.ACTIVER);
        userRepository.save(users);
        return "Utilisateur" +users.getNom()+" c'est connecter avec succès ";
    }
    //affichier la liste des utilisateurs activer
    @Override
    public List<Users> lister() {
        return userRepository.lister();
    }
}
