package com.example.gesticket.service;

import com.example.gesticket.modele.Formateur;
import com.example.gesticket.repository.FormateurRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Data
public class FormateurServiceImplement implements FormateurService{
    private FormateurRepository formateurRepository;
    @Override
    public List<Formateur> readFormateurs() {
        return formateurRepository.findAll();
    }

    @Override
    public String deleteFormateur(long id) {
        if (formateurRepository.existsById(id)) {
            formateurRepository.deleteById(id);
            return "Formateur supprimé avec succès";
        } else {
            return "Formateur non trouvé";
        }
    }

    @Override
    public Formateur update(Formateur formateur, long id) {
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
}
