package com.example.gesticket.modele;

import com.example.gesticket.Enum.Categorie;
import com.example.gesticket.Enum.EtatTicket;
import com.example.gesticket.Enum.Priorite;
import com.example.gesticket.modele.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private LocalDateTime dateCreation;
    @Enumerated(EnumType.STRING)
    private EtatTicket etat;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

}
