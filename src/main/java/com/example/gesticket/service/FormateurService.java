package com.example.gesticket.service;

import com.example.gesticket.modele.Formateur;

import java.util.List;

public interface FormateurService {
    List<Formateur> readFormateurs();
    String deleteFormateur(long id);
    Formateur update(Formateur formateur, long id);
    Formateur create(Formateur formateur);
}
