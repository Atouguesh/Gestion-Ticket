package com.example.gesticket.service;

import com.example.gesticket.modele.Admin;
import com.example.gesticket.modele.Apprenant;
import com.example.gesticket.modele.Ticket;
import com.example.gesticket.repository.ApprenantRepository;
import com.example.gesticket.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApprenantServiceImplement implements ApprenantService{
    @Autowired
    private ApprenantRepository apprenantRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private NotificationService notificationService;

    public Apprenant saveApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    @Override
    public List<Ticket> getTicketsByApprenantId(Long apprenantId) {
        Apprenant apprenant = apprenantRepository.findById(apprenantId).orElse(null);
        return apprenant != null ? apprenant.getTickets() : null;
    }


        //Apprenant apprenant = new Apprenant();
       // ticket.setApprenant(apprenantRepository.findById(apprenantId));


    @Override
    public Ticket saveTicket(Ticket ticket) {
        Ticket savedTicket = ticketRepository.save(ticket);
        notificationService.notifyFormateur(savedTicket);
        return savedTicket;
    }


    @Override
    public Apprenant createApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    @Override
    public Apprenant updateApprenant(Apprenant apprenant, Long id) {
        Optional<Apprenant> App = apprenantRepository.findById(id);
        if (App.isPresent()) {
            Apprenant App2= App.get();
            App2.setId(apprenant.getId());
            App2.setNom(apprenant.getNom());
            App2.setEmail(apprenant.getEmail());
            return apprenantRepository.save(App2);

        }else {
            return null;
        }
    }

    @Override
    public String deleteApprenant(Long id) {
        if (apprenantRepository.existsById(id)) {
            apprenantRepository.deleteById(id);
            return "Supprimé avec succès";
        } else {
            return "Non trouvé";
        }
    }

    @Override
    public List<Apprenant> readApprenants() {
        return apprenantRepository.findAll();
    }

    @Override
    public Apprenant findById(Long id) {
        return apprenantRepository.findById(id).orElse(null);
    }
}
