package com.example.gesticket.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "formateur")
public class Formateur extends Users{


    private String prenom;

    @JsonIgnore
    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    //Dans Formateur, nous avons une relation OneToMany avec Ticket. Cela signifie qu'un formateur peut avoir plusieurs tickets.
    private List<Ticket> tickets;
    @JsonIgnore
    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    //Dans Formateur, nous avons une relation OneToMany avec BaseDeConnaissance. Cela signifie qu'un formateur peut créer plusieurs contenus dans la base de connaissance.
    private List<BasedeConnaissances> basesdeConnaissances;

}
