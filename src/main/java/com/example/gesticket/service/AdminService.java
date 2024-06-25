package com.example.gesticket.service;

import com.example.gesticket.modele.Admin;
import com.example.gesticket.modele.BasedeConnaissances;

import java.util.List;

public interface AdminService {
        Admin createAdmin(Admin admin);
        Admin updateAdmin(Admin admin, int id);
        String deleteAdmin(int id);
        List<Admin> readAdmin();
        List<BasedeConnaissances> getBasesDeConnaissanceByAdminId(int adminId);
        Admin findById(int id);
        BasedeConnaissances saveBasedeConnaissance(BasedeConnaissances basedeConnaissance);

}
