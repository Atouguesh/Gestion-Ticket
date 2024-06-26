package com.example.gesticket.controller;

import com.example.gesticket.modele.Apprenant;
import com.example.gesticket.modele.Ticket;
import com.example.gesticket.service.ApprenantService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apprenant")
@Data
public class ApprenantController {
    private ApprenantService apprenantService;

    @PostMapping("/create")
    public Apprenant create (@RequestBody Apprenant apprenant){
        return apprenantService.createApprenant(apprenant);
    }

    @PostMapping("/{apprenantId}/tickets")
    public Ticket createTicket(@PathVariable Long apprenantId, @RequestBody Ticket ticket) {
        Apprenant apprenant = apprenantService.saveApprenant(apprenantService.findById(apprenantId));
        ticket.setApprenant(apprenant);
        return apprenantService.saveTicket(ticket);
    }

    @PutMapping("/update/{id}")
    public Apprenant update (@RequestBody Apprenant apprenant, @PathVariable Long id){
        return apprenantService.updateApprenant(apprenant, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
        return apprenantService.deleteApprenant(id);
    }

    @GetMapping
    public List<Apprenant> readAll(){
        return apprenantService.readApprenants();
    }

    @GetMapping("/{apprenantId}/tickets")
    public List<Ticket> getTicketsByApprenantId(@PathVariable Long apprenantId) {
        return apprenantService.getTicketsByApprenantId(apprenantId);
    }
}
