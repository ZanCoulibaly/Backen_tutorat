package com.tutoratbackend.tutorat.services;

import com.tutoratbackend.tutorat.model.Users;

import java.util.List;

public interface UserService {
    public String addUsers(Users users);
    public List<Users> lister();
    public List<Users> listeCorbeille();
    public Users findByIdUsers(Long id);
    public void supprimerUsers(Long id);
    public void recupere(Long id);
    public String modifier(Users users, Long id);
    public List<Users> loginVerify(String email, String password);
}
