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

    @Override
    public List<Users> listeCorbeille() {
        return userRepository.listeCorbeille();
    }

    @Override
    public Users findByIdUsers(Long id) {
        Users users = userRepository.findById(id).orElseThrow();
        if (users.getEtat()==Etat.ACTIVER){
            return users;
        }
        return null;
    }

    @Override
    public void supprimerUsers(Long id) {
        Users users = userRepository.findById(id).get();
        users.setEtat(Etat.DESACTIVER);
        userRepository.save(users);
    }

    @Override
    public void recupere(Long id) {
        Users users = userRepository.findById(id).get();
        users.setEtat(Etat.ACTIVER);
        userRepository.save(users);
    }

    @Override
    public String modifier(Users users, Long id) {
        Users modifier = userRepository.findById(id).get();

        modifier.setNom(users.getNom());
        modifier.setPrenom(users.getPrenom());
        modifier.setAddresse(users.getAddresse());
        modifier.setPassword(users.getPassword());
        modifier.setEmail(users.getEmail());
        userRepository.save(modifier);
        return "votre coordonné a été modifier avec succès";
    }

    @Override
    public List<Users> loginVerify(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
