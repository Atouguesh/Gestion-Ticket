package com.example.gesticket.service;

import com.example.gesticket.modele.Users;
import com.example.gesticket.repository.UsersRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class UsersServiceImplement implements UsersService{
    private UsersRepository usersRepository;
    @Override
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Users getUser(int id) {
        return usersRepository.getOne((long) id);
    }


    @Override
    public Users updateUser(Users user , long id) {
       Optional<Users> optionalUser = usersRepository.findById((long) id);
       if (optionalUser.isPresent()) {
           Users users = optionalUser.get();
           users.setNom(user.getNom());
           users.setEmail(user.getEmail());
           users.setPassword(user.getPassword());
           usersRepository.save(users);
           return users;
       } else {
           return null;
       }
    }

    @Override
    public String deleteUser(int id) {
        if (usersRepository.existsById((long) id)) {
            usersRepository.deleteById((long) id);
            return "Utilisateur supprimé avec succès";
        }else {
            return "Utilisateur non trouvé";
        }

    }
}
