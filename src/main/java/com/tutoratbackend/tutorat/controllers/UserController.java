package com.tutoratbackend.tutorat.controllers;

import com.tutoratbackend.tutorat.model.Users;
import com.tutoratbackend.tutorat.services.UserServiceImp;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;
    //ajouter un utilisateur
    @PostMapping("/add")
    public String addUsers(@RequestBody Users users){
        String randomCode = RandomString.make(14);
        users.setPassword(randomCode);
        userServiceImp.addUsers(users);
        return "inscript avec succès";
    }
    //lister les utilisateurs activer
    @GetMapping("/liste")
    public List<Users> lister(){
        return userServiceImp.lister();
    }
    //rechercher par son id
    @GetMapping("/getById/{id}")
    public Users findById(@PathVariable("id") Long id){
        return userServiceImp.findByIdUsers(id);
    }
    //supprimer par son id
    @PutMapping("/supprimer/{id}")
    public void supprimerUsers(@PathVariable("id") Long id){
        userServiceImp.supprimerUsers(id);
    }

    @PutMapping("/modify/{id}")
    public String modifier(@RequestBody Users users, @PathVariable Long id){
        return userServiceImp.modifier(users, id);
    }

}
