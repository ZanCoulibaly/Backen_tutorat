package com.tutoratbackend.tutorat.services;

import com.tutoratbackend.tutorat.model.Users;

import java.util.List;

public interface UserService {
    public String addUsers(Users users);
    public List<Users> lister();
}
