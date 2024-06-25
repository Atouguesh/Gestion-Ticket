package com.example.gesticket.modele;

import com.example.gesticket.Enum.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@Data
public abstract class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
