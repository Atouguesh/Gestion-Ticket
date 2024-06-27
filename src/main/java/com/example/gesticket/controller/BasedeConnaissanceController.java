package com.example.gesticket.controller;

import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.service.BasedeConnaissanceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basedeConnaissance")
@Data
public class BasedeConnaissanceController {
    @Autowired
    private BasedeConnaissanceService basedeConnaissanceService;

    @Operation(summary = "Création de l'utilisateur", description = "Cet endpoint nous permet de créer l'utilisateur")
    @PostMapping("/create")
    public BasedeConnaissances create(@RequestBody BasedeConnaissances basedeConnaissances){
        return basedeConnaissanceService.create(basedeConnaissances);
    }

    @Operation(summary = "Modification de l'utilisateur", description = "Cet endpoint nous permet de modifier toutes les informations sur l'utilisateur")
    @PutMapping("/update/{id}")
    public BasedeConnaissances update(@RequestBody BasedeConnaissances basedeConnaissances , @PathVariable Long id){
        return basedeConnaissanceService.update(basedeConnaissances , id);
    }

    @Operation(summary = "Suppression de l'utilisateur", description = "Cet endpoint nous permet de supprimer l'utilisateur par son ID")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return basedeConnaissanceService.deleteBasedeConnaissances(id);
    }

    @Operation(summary = "Liste des utilisateurs", description = "Cet endpoint nous permet de lister les utilisateurs ")
    @GetMapping
    public List<BasedeConnaissances> getAll(){
        return basedeConnaissanceService.getAllBasedeConnaissances();
    }

}
