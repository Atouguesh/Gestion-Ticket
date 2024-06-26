package com.example.gesticket.service;

import com.example.gesticket.modele.Users;

public interface UsersService {
    Users createUser(Users user);
    Users getUser(Long id);
    Users updateUser(Users user , long id);
    String deleteUser(Long id);

}
