package com.tutoratbackend.tutorat.services;

import com.tutoratbackend.tutorat.model.Users;

import java.util.List;

public interface UserService {
    public String addUsers(Users users);
    public List<Users> lister();
    public Users findByIdUsers(Long id);
    public void supprimerUsers(Long id);
    public String modifier(Users users, Long id);
}
