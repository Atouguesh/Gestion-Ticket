package com.example.gesticket.controller;

import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.modele.Formateur;
import com.example.gesticket.modele.Ticket;
import com.example.gesticket.service.FormateurService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
@Data
public class FormateurController {
    @Autowired
    private FormateurService formateurService;

    @Operation(summary = "Création de l'utilisateur", description = "Cet endpoint nous permet de créer l'utilisateur")
    @PostMapping("/create")
    public Formateur create(Formateur formateur) {
        return formateurService.create(formateur);
    }

    @PostMapping("/{formateurId}/tickets")
    public Ticket createTicket(@PathVariable Long formateurId, @RequestBody Ticket ticket) {
        Formateur formateur = formateurService.findById(formateurId);
        if (formateur != null) {
            ticket.setFormateur(formateur);
            return formateurService.saveTicket(ticket);
        } else {
            // Gérer le cas où le formateur n'existe pas (peut-être lancer une exception ou retourner un code d'erreur)
            return null;
        }
    }

    @GetMapping("/{formateurId}/tickets")
    public List<Ticket> getTicketsByFormateurId(@PathVariable Long formateurId) {
        return formateurService.getTicketsByFormateurId(formateurId);
    }

    @PostMapping("/{formateurId}/basesDeConnaissance")
    public BasedeConnaissances createBasedeConnaissance(@PathVariable Long formateurId, @RequestBody BasedeConnaissances basedeConnaissance) {
        Formateur formateur = formateurService.findById(formateurId);
        if (formateur != null) {
            basedeConnaissance.setFormateur(formateur);
            return formateurService.saveBasedeConnaissance(basedeConnaissance);
        } else {
            // Gérer le cas où le formateur n'existe pas (peut-être lancer une exception ou retourner un code d'erreur)
            return null;
        }
    }

    @GetMapping("/{formateurId}/basesDeConnaissance")
    public List<BasedeConnaissances> getBasesDeConnaissanceByFormateurId(@PathVariable Long formateurId) {
        return formateurService.getBasesDeConnaissanceByFormateurId(formateurId);
    }

    @PutMapping("/basesDeConnaissance/{baseId}")
    public BasedeConnaissances updateBasedeConnaissance(@PathVariable Long baseId, @RequestBody String contenu) {
        return formateurService.updateBasedeConnaissance(baseId, contenu);
    }

    @Operation(summary = "Liste des utilisateurs", description = "Cet endpoint nous permet de lister les utilisateurs ")
    @GetMapping
    public List<Formateur> readAllTickets() {
        return formateurService.readFormateurs();
    }

    @Operation(summary = "Modification de l'utilisateur", description = "Cet endpoint nous permet de modifier toutes les informations sur l'utilisateur")
    @PutMapping("/update/{id}")
    public Formateur update(@PathVariable Long id, @RequestBody Formateur formateur) {
        return  formateurService.update(formateur, id);
    }

    @Operation(summary = "Suppression de l'utilisateur", description = "Cet endpoint nous permet de supprimer l'utilisateur par son ID")
    @DeleteMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {
        return formateurService.deleteFormateur(id);
    }

}
