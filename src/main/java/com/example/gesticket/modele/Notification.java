package com.example.gesticket.modele;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

}
