package com.example.gesticket.service;

import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.modele.Formateur;
import com.example.gesticket.modele.Ticket;
import com.example.gesticket.repository.BasedeConnaissanceRepository;
import com.example.gesticket.repository.FormateurRepository;
import com.example.gesticket.repository.TicketRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Data
public class FormateurServiceImplement implements FormateurService{
    @Autowired
    private FormateurRepository formateurRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Formateur saveFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getTicketsByFormateurId(Long formateurId) {
        Formateur formateur = findById(formateurId);
        return formateur != null ? formateur.getTickets() : null;
    }

    @Override
    public Formateur findById(Long id) {
        return formateurRepository.findById(id).orElse(null);
    }

    public BasedeConnaissances updateBasedeConnaissance(Long baseId, String contenu) {
        BasedeConnaissances base = basedeConnaissanceRepository.findById(baseId).orElse(null);
        if (base != null) {
            base.setContenu(contenu);
            return basedeConnaissanceRepository.save(base);
        }
        return null;
    }


    @Override
    public List<Formateur> readFormateurs() {
        return formateurRepository.findAll();
    }

    @Override
    public String deleteFormateur(Long id) {
        if (formateurRepository.existsById(id)) {
            formateurRepository.deleteById(id);
            return "Formateur supprimé avec succès";
        } else {
            return "Formateur non trouvé";
        }
    }

    @Override
    public Formateur update(Formateur formateur, Long id) {
        Optional<Formateur> formateur1 = formateurRepository.findById(id);
        if (formateur1.isPresent()) {
            Formateur formateur2 = formateur1.get();
            formateur2.setNom(formateur.getNom());
            formateur2.setPrenom(formateur.getPrenom());
            formateur2.setEmail(formateur.getEmail());
            formateurRepository.save(formateur1.get());
        }
        return null;
    }

    @Override
    public Formateur create(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Autowired
    private BasedeConnaissanceRepository basedeConnaissanceRepository;

    public BasedeConnaissances saveBasedeConnaissance(BasedeConnaissances basedeConnaissance) {
        return basedeConnaissanceRepository.save(basedeConnaissance);
    }

    public List<BasedeConnaissances> getBasesDeConnaissanceByFormateurId(Long formateurId) {
        Formateur formateur = findById(formateurId);
        return formateur != null ? formateur.getBasesdeConnaissances(): null;
    }

}
