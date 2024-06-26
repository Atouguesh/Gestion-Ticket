package com.example.gesticket.Conf;

import com.example.gesticket.modele.Users;
import com.example.gesticket.service.ManagerAccountService;
import lombok.AllArgsConstructor;
import org.apache.catalina.Manager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    ManagerAccountService managerAccountService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        System.out.println("Hi1");
        Users user = managerAccountService.loadUserByEmail(email);
        System.out.println("Hi2");
        if (user == null) throw new UsernameNotFoundException("Utilisateur n'existe pas");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getRole().toString());

        return User.withUsername(user.getEmail()).password(user.getPassword()).roles(user.getRole().toString()).build();
    }
}
