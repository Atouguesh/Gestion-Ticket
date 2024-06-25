package com.example.gesticket.controller;

import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.modele.Formateur;
import com.example.gesticket.modele.Ticket;
import com.example.gesticket.service.FormateurService;
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
    @PostMapping("/create")
    public Formateur create(Formateur formateur) {
        return formateurService.create(formateur);
    }

    @PostMapping("/{formateurId}/tickets")
    public Ticket createTicket(@PathVariable int formateurId, @RequestBody Ticket ticket) {
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
    public List<Ticket> getTicketsByFormateurId(@PathVariable int formateurId) {
        return formateurService.getTicketsByFormateurId(formateurId);
    }

    @PostMapping("/{formateurId}/basesDeConnaissance")
    public BasedeConnaissances createBasedeConnaissance(@PathVariable int formateurId, @RequestBody BasedeConnaissances basedeConnaissance) {
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
    public List<BasedeConnaissances> getBasesDeConnaissanceByFormateurId(@PathVariable int formateurId) {
        return formateurService.getBasesDeConnaissanceByFormateurId(formateurId);
    }

    @PutMapping("/basesDeConnaissance/{baseId}")
    public BasedeConnaissances updateBasedeConnaissance(@PathVariable int baseId, @RequestBody String contenu) {
        return formateurService.updateBasedeConnaissance(baseId, contenu);
    }

    @GetMapping
    public List<Formateur> readAllTickets() {
        return formateurService.readFormateurs();
    }

    @PutMapping("/update/{id}")
    public Formateur update(@PathVariable int id, @RequestBody Formateur formateur) {
        return  formateurService.update(formateur, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTicket(@PathVariable int id) {
        return formateurService.deleteFormateur(id);
    }

}
