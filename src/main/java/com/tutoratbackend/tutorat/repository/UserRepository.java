package com.tutoratbackend.tutorat.repository;

import com.tutoratbackend.tutorat.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("SELECT p FROM Users p WHERE p.etat='ACTIVER'")
    public List<Users> lister();
}
