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
        userServiceImp.addUsers(users);
        return "inscript avec succès";
    }
    //lister les utilisateurs activer
    @GetMapping("/liste")
    public List<Users> lister(){
        return userServiceImp.lister();
    }
    //corbeille
    @GetMapping("/listeCorbeille")
    public List<Users> listeCorbeille(){
        return userServiceImp.listeCorbeille();
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
    //corbeille
    @PutMapping("/recupere/{id}")
    public  void recupere(@PathVariable("id") Long id){userServiceImp.recupere(id);}

    @PutMapping("/modify/{id}")
    public String modifier(@RequestBody Users users, @PathVariable Long id){
        //String randomCode = RandomString.make(14);
        //users.setPassword(randomCode);
        return userServiceImp.modifier(users, id);
    }
    @GetMapping("/login/{email}&{password}")
    public List<Users> Login(@PathVariable String email, @PathVariable String password){
        return userServiceImp.loginVerify(email, password);
    }

}
