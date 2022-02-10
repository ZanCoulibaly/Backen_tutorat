package com.tutoratbackend.tutorat.repository;

import com.tutoratbackend.tutorat.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@CrossOrigin("*")
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("SELECT p FROM Users p WHERE p.etat='ACTIVER'")
    public List<Users> lister();

    @Query("SELECT p FROM Users p WHERE p.etat='DESACTIVER'")
    public List<Users> listeCorbeille();

    //@Query("SELECT p FROM Users p WHERE p.etat='ACTIVER' and p.email= :email and p.password= :password")
    //public String loginVerify (String email, String password);

    public List<Users> findByEmailAndPassword(String email, String password);
}
