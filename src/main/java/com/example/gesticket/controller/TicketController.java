package com.example.gesticket.controller;

import com.example.gesticket.modele.Ticket;
import com.example.gesticket.service.ApprenantService;
import com.example.gesticket.service.NotificationService;
import com.example.gesticket.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {
    @Autowired
    private TicketService ticketService;// Inversion de contrôle ici on passe par l'interface pour appeller les méthodes de service implement.
    private NotificationService notificationService;
    private ApprenantService apprenantService;

    @Operation(summary = "Liste des utilisateurs", description = "Cet endpoint nous permet de lister les utilisateurs ")
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketWithFormateurAndApprenant(id);
        return ResponseEntity.ok(ticket);
    }

    @Operation(summary = "Création de l'utilisateur", description = "Cet endpoint nous permet de créer l'utilisateur")
    @PostMapping("/create")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @Operation(summary = "Liste des utilisateurs", description = "Cet endpoint nous permet de lister les utilisateurs ")
    @GetMapping
    public List<Ticket> readAllTickets() {
        return ticketService.readTickets();
    }

    @Operation(summary = "Modification de l'utilisateur", description = "Cet endpoint nous permet de modifier toutes les informations sur l'utilisateur")
    @PutMapping("/update/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return  ticketService.updateTicket(ticket, id);
   }

    @Operation(summary = "Création de l'utilisateur", description = "Cet endpoint nous permet de créer l'utilisateur")
    @PostMapping("/submit")
    public ResponseEntity<Ticket> submitTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = apprenantService.saveTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }

    @Operation(summary = "Suppression de l'utilisateur", description = "Cet endpoint nous permet de supprimer l'utilisateur par son ID")
    @DeleteMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {
        return ticketService.deleteTicket(id);
   }

}
