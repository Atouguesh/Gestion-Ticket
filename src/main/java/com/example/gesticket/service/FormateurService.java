package com.example.gesticket.service;

import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.modele.Formateur;
import com.example.gesticket.modele.Ticket;

import java.util.List;

public interface FormateurService {
    List<Formateur> readFormateurs();
    String deleteFormateur(Long id);
    Formateur update(Formateur formateur, Long id);
    Formateur create(Formateur formateur);
    Formateur saveFormateur (Formateur formateur);
    Ticket saveTicket(Ticket ticket);

    List<Ticket> getTicketsByFormateurId(Long formateurId);

    Formateur findById(Long id);
    BasedeConnaissances saveBasedeConnaissance (BasedeConnaissances basedeConnaissance);
    List<BasedeConnaissances> getBasesDeConnaissanceByFormateurId (Long id);
    BasedeConnaissances updateBasedeConnaissance (Long baseId, String contenu);
}
