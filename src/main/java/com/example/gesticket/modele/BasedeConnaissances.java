package com.example.gesticket.modele;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "BasedeConnaissances")
public class BasedeConnaissances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
    //Dans BaseDeConnaissance, nous avons une relation ManyToOne avec Formateur. Cela signifie qu'un contenu de la base de connaissance est associé à un seul formateur.

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
