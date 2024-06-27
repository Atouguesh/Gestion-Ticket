package com.example.gesticket.service;

import com.example.gesticket.modele.Ticket;
import com.example.gesticket.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketServiceImplement implements TicketService {
    private final  TicketRepository ticketRepository;//Injection par constructeur de notre repository
    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> readTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket updateTicket(Ticket ticket, Long id) {
        Optional<Ticket> tickets = ticketRepository.findById(id);
        if (tickets.isPresent()) {
            Ticket t  = tickets.get();
            t.setDescription(ticket.getDescription());
            t.setDateCreation(ticket.getDateCreation());
            t.setTitre(ticket.getTitre());
            t.setEtat(ticket.getEtat());
            t.setPriorite(ticket.getPriorite());
            t.setCategorie(ticket.getCategorie());
            Ticket updatedTicket = ticketRepository.save(t);
          return updatedTicket;
        }
        else {
            return null;
        }
    }

    @Override
    public String deleteTicket(long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return "Ticket supprimé avec succès";
        } else {
            return "Ticket non trouvé";
        }
    }

    @Override
    public Ticket getTicketWithFormateurAndApprenant(Long ticketId) {
        return ticketRepository.findByIdWithFormateurAndApprenant(ticketId);
    }
}
