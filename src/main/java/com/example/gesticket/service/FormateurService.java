package com.example.gesticket.service;

import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.modele.Formateur;
import com.example.gesticket.modele.Ticket;

import java.util.List;

public interface FormateurService {
    List<Formateur> readFormateurs();
    String deleteFormateur(int id);
    Formateur update(Formateur formateur, int id);
    Formateur create(Formateur formateur);
    Formateur saveFormateur (Formateur formateur);
    Ticket saveTicket(Ticket ticket);

    List<Ticket> getTicketsByFormateurId(int formateurId);

    Formateur findById(int id);
    BasedeConnaissances saveBasedeConnaissance (BasedeConnaissances basedeConnaissance);
    List<BasedeConnaissances> getBasesDeConnaissanceByFormateurId (int id);
    BasedeConnaissances updateBasedeConnaissance (int baseId, String contenu);
}
