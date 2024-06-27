package com.example.gesticket.controller;

import com.example.gesticket.modele.Apprenant;
import com.example.gesticket.modele.Ticket;
import com.example.gesticket.service.ApprenantService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apprenant")
@AllArgsConstructor
public class ApprenantController {
    private ApprenantService apprenantService;

    @Operation(summary = "Création de l'utilisateur", description = "Cet endpoint nous permet de créer l'utilisateur")
    @PostMapping("/create")
    public Apprenant create (@RequestBody Apprenant apprenant){
        return apprenantService.createApprenant(apprenant);
    }

    @Operation(summary = "Création de l'utilisateur", description = "Cet endpoint nous permet de créer l'utilisateur")
    @PostMapping("/{apprenantId}/tickets")
    public Ticket createTicket(@PathVariable Long apprenantId, @RequestBody Ticket ticket) {
        Apprenant apprenant = apprenantService.saveApprenant(apprenantService.findById(apprenantId));
        ticket.setApprenant(apprenant);
        return apprenantService.saveTicket(ticket);
    }

    @Operation(summary = "Modification de l'utilisateur", description = "Cet endpoint nous permet de modifier toutes les informations sur l'utilisateur")
    @PutMapping("/update/{id}")
    public Apprenant update (@RequestBody Apprenant apprenant, @PathVariable Long id){
        return apprenantService.updateApprenant(apprenant, id);
    }

    @Operation(summary = "Suppression de l'utilisateur", description = "Cet endpoint nous permet de supprimer l'utilisateur par son ID")
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        return apprenantService.deleteApprenant(id);
    }

    @Operation(summary = "Liste des utilisateurs", description = "Cet endpoint nous permet de lister les utilisateurs ")
    @GetMapping
    public List<Apprenant> readAll(){
        return apprenantService.readApprenants();
    }

    @Operation(summary = "Liste des utilisateurs", description = "Cet endpoint nous permet de lister les utilisateurs ")
    @GetMapping("/{apprenantId}/tickets")
    public List<Ticket> getTicketsByApprenantId(@PathVariable Long apprenantId) {
        return apprenantService.getTicketsByApprenantId(apprenantId);
    }
}
