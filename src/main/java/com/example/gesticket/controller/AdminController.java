package com.example.gesticket.controller;

import com.example.gesticket.modele.Admin;
import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private AdminService adminService;

    @Operation(summary = "Création de l'utilisateur", description = "Cet endpoint nous permet de créer l'utilisateur")
    @PostMapping("/create")
    public Admin create (@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

    @Operation(summary = "Suppression de l'utilisateur", description = "Cet endpoint nous permet de supprimer l'utilisateur par son ID")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return adminService.deleteAdmin(id);
    }

    @Operation(summary = "Modification de l'utilisateur", description = "Cet endpoint nous permet de modifier toutes les informations sur l'utilisateur")
    @PutMapping("/update/{id}")
    public Admin update (@RequestBody Admin admin , @PathVariable Long id){
        return adminService.updateAdmin(admin,id);
    }

    @Operation(summary = "Liste des utilisateurs", description = "Cet endpoint nous permet de lister les utilisateurs ")
    @GetMapping
    public List<Admin> readAllAdmin(){
        return adminService.readAdmin();
    }

    @Operation(summary = "Création de l'utilisateur", description = "Cet endpoint nous permet de créer l'utilisateur")
    @PostMapping("/{adminId}/basesDeConnaissance")
    public BasedeConnaissances createBaseDeConnaissance(@PathVariable Long adminId, @RequestBody BasedeConnaissances basedeConnaissance) {
        Admin admin = adminService.findById(adminId);
        if (admin != null) {
            basedeConnaissance.setAdmin(admin);
            return adminService.saveBasedeConnaissance(basedeConnaissance);
        } else {
            // Gérer le cas où l'admin n'existe pas (peut-être lancer une exception ou retourner un code d'erreur)
            return null;
        }
    }

    @Operation(summary = "Liste des utilisateurs", description = "Cet endpoint nous permet de lister les utilisateurs ")
    @GetMapping("/{adminId}/basesDeConnaissance")
    public List<BasedeConnaissances> getBasesDeConnaissanceByAdminId(@PathVariable Long adminId) {
        return adminService.getBasesDeConnaissanceByAdminId(adminId);
    }
}
