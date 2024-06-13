package com.example.gesticket.repository;

import com.example.gesticket.modele.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
