package com.example.gesticket.service;

import com.example.gesticket.modele.Admin;
import com.example.gesticket.modele.BasedeConnaissances;

import java.util.List;

public interface AdminService {
        Admin createAdmin(Admin admin);
        Admin updateAdmin(Admin admin, Long id);
        String deleteAdmin(Long id);
        List<Admin> readAdmin();
        List<BasedeConnaissances> getBasesDeConnaissanceByAdminId(Long adminId);
        Admin findById(Long id);
        BasedeConnaissances saveBasedeConnaissance(BasedeConnaissances basedeConnaissance);

}
