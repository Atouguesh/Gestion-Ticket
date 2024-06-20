package com.example.gesticket.controller;

import com.example.gesticket.modele.Formateur;
import com.example.gesticket.modele.Ticket;
import com.example.gesticket.service.FormateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FormateurController {
    private FormateurService formateurService;
    @PostMapping("/create")
    public Formateur create(Formateur formateur) {
        return formateurService.create(formateur);
    }

    @GetMapping
    public List<Formateur> readAllTickets() {
        return formateurService.readFormateurs();
    }

    @PutMapping("/update/{id}")
    public Formateur update(@PathVariable Long id, @RequestBody Formateur formateur) {
        return  formateurService.update(formateur, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {
        return formateurService.deleteFormateur(id);
    }

}
