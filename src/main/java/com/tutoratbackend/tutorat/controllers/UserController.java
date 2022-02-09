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
}
