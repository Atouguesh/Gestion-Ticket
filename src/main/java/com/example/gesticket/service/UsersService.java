package com.example.gesticket.service;

import com.example.gesticket.modele.Users;

public interface UsersService {
    Users createUser(Users user);
    Users getUser(int id);
    Users updateUser(Users user , long id);
    String deleteUser(int id);

}
