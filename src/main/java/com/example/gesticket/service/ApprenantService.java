package com.example.gesticket.service;

import com.example.gesticket.modele.Apprenant;
import com.example.gesticket.modele.Ticket;

import java.util.List;

public interface ApprenantService {
    Apprenant createApprenant(Apprenant apprenant);
    Apprenant updateApprenant (Apprenant apprenant, int id);
    String deleteApprenant (int id);
    List<Apprenant> readApprenants();

    Apprenant findById(int apprenantId);

    Ticket saveTicket(Ticket ticket);

    Apprenant saveApprenant(Apprenant byId);

    List<Ticket> getTicketsByApprenantId(int apprenantId);
}
