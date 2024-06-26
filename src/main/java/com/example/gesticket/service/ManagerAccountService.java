package com.example.gesticket.service;

import com.example.gesticket.modele.Users;

public interface ManagerAccountService {
    Users loadUserByEmail(String email);
}
