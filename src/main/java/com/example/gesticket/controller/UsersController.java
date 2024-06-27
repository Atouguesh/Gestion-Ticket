package com.example.gesticket.controller;

import com.example.gesticket.modele.Users;
import com.example.gesticket.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(description ="Contrôleur de Usesrs", name = "Users-API")
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Operation(summary = "Liste des utilisateurs", description = "Cet endpoint nous permet de lister les utilisateurs ")
    @GetMapping
    public UsersService getUsersService() {
        return usersService;
    }

    @Operation(summary = "Création de l'utilisateur", description = "Cet endpoint nous permet de créer l'utilisateur")
    @PostMapping("/create")
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @Operation(summary = "Suppression de l'utilisateur", description = "Cet endpoint nous permet de supprimer l'utilisateur par son ID")
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return usersService.deleteUser(id);
    }

    @Operation(summary = "Modification de l'utilisateur", description = "Cet endpoint nous permet de modifier toutes les informations sur l'utilisateur")
    @PutMapping("/update")
    public Users updateUser(@RequestBody Users user , @PathVariable long id){
        return usersService.updateUser(user,id);
    }

}
