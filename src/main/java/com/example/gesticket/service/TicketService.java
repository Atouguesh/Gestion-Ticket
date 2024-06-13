package com.example.gesticket.service;

import com.example.gesticket.modele.Ticket;

import java.util.List;

public interface TicketService {
    Ticket createTicket(Ticket ticket);
    List<Ticket> readTickets();
    Ticket updateTicket(Ticket ticket,long id);
    Ticket deleteTicket(long id);

}
