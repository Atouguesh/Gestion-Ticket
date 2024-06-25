package com.example.gesticket.modele;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "formateur")
public class Formateur extends Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;

    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    //Dans Formateur, nous avons une relation OneToMany avec Ticket. Cela signifie qu'un formateur peut avoir plusieurs tickets.
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    //Dans Formateur, nous avons une relation OneToMany avec BaseDeConnaissance. Cela signifie qu'un formateur peut créer plusieurs contenus dans la base de connaissance.
    private List<BasedeConnaissances> basesdeConnaissances;

}
