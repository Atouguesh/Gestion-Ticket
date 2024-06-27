package com.example.gesticket.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "Apprenant")
public class Apprenant extends Users{
    @JsonIgnore
    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL)
    private List<Ticket> tickets;


}
