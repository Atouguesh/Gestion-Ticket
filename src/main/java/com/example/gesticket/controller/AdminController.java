package com.example.gesticket.controller;

import com.example.gesticket.modele.Admin;
import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.service.AdminService;
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

    @PostMapping("/create")
    public Admin create (@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return adminService.deleteAdmin(id);
    }

    @PutMapping("/update/{id}")
    public Admin update (@RequestBody Admin admin , @PathVariable Long id){
        return adminService.updateAdmin(admin,id);
    }

    @GetMapping
    public List<Admin> readAllAdmin(){
        return adminService.readAdmin();
    }

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

    @GetMapping("/{adminId}/basesDeConnaissance")
    public List<BasedeConnaissances> getBasesDeConnaissanceByAdminId(@PathVariable Long adminId) {
        return adminService.getBasesDeConnaissanceByAdminId(adminId);
    }
}
