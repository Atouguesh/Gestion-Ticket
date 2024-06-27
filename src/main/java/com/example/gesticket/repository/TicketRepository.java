package com.example.gesticket.repository;

import com.example.gesticket.modele.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface    TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t JOIN FETCH t.formateur f JOIN FETCH t.apprenant a WHERE t.id = :ticketId")
    Ticket findByIdWithFormateurAndApprenant(@Param("ticketId") Long ticketId);
}
