package com.tutoratbackend.tutorat.model;

import com.tutoratbackend.tutorat.enumeration.Disponible;
import com.tutoratbackend.tutorat.enumeration.Etat;
import com.tutoratbackend.tutorat.enumeration.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String etablissement;
    private String matieresEnseigner;
    private String addresse;
    private String classeEnseigner;
    private String matieresMaitrice;


    @Enumerated(EnumType.STRING)
    private Profile profile= Profile.USER;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    @Enumerated(EnumType.STRING)
    private Disponible disponible= Disponible.OUI;
}
