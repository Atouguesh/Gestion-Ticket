package com.example.gesticket.modele;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Apprenant")
public class Apprenant extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String email;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
