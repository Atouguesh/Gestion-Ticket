package com.example.gesticket.service;

import com.example.gesticket.modele.Users;
import com.example.gesticket.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ManagerAccountServiceImplement implements ManagerAccountService{
    private UsersRepository usersRepository;

    @Override
    public Users loadUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
