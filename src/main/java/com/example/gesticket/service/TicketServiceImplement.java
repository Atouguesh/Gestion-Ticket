package com.example.gesticket.service;

import com.example.gesticket.modele.Ticket;
import com.example.gesticket.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TicketServiceImplement implements TicketService {
    private final  TicketRepository ticketRepository;
    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> readTickets() {
        return List.of();
    }

    @Override
    public Ticket updateTicket(Ticket ticket, long id) {
        return ticketRepository.findBy(id).map(t-> {
            t.set
        });
    }

    @Override
    public Ticket deleteTicket(long id) {
        return null;
    }
}
