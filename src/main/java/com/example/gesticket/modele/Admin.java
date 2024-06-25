package com.example.gesticket.modele;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Admin")
public class Admin extends Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    //Dans Admin, nous avons une relation OneToMany avec BaseDeConnaissance. Cela signifie qu'un admin peut créer plusieurs entrées dans la base de connaissance.
    private List<BasedeConnaissances> basedeConnaissance;
}