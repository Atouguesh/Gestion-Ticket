package com.example.gesticket.service;

import com.example.gesticket.modele.Admin;
import com.example.gesticket.modele.BasedeConnaissances;
import com.example.gesticket.repository.AdminRepository;
import com.example.gesticket.repository.BasedeConnaissanceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class AdminServiceImplement implements AdminService {
    private AdminRepository adminRepository;
    @Autowired
    private BasedeConnaissanceRepository basedeConnaissanceRepository;

    public Admin findById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public BasedeConnaissances saveBasedeConnaissance(BasedeConnaissances basedeConnaissance) {
        return basedeConnaissanceRepository.save(basedeConnaissance);
    }

    public List<BasedeConnaissances> getBasesDeConnaissanceByAdminId(int adminId) {
        Admin admin = findById(adminId);
        return admin != null ? admin.getBasedeConnaissance() : null;
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin, int id) {
            Optional<Admin> Admin1 = adminRepository.findById(id);
        if (Admin1.isPresent()) {
            Admin Admin2= Admin1.get();
            Admin2.setId(admin.getId());
            Admin2.setNom(admin.getNom());
            Admin2.setPrenom(admin.getPrenom());
            Admin2.setEmail(admin.getEmail());
            return adminRepository.save(Admin2);

        }else {
            return null;
        }
    }

    @Override
    public String deleteAdmin(int id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return "Supprimé avec succès";
        } else {
            return "Non trouvé";
        }
    }

    @Override
    public List<Admin> readAdmin() {
        return adminRepository.findAll();
    }
}
