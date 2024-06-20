package com.example.gesticket.modele;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "formateur")
public class Formateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;

}
