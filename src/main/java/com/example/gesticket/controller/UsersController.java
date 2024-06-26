package com.example.gesticket.controller;

import com.example.gesticket.modele.Users;
import com.example.gesticket.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping
    public UsersService getUsersService() {
        return usersService;
    }
    @PostMapping("/create")
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return usersService.deleteUser(id);
    }

    @PutMapping("/update")
    public Users updateUser(@RequestBody Users user , @PathVariable long id){
        return usersService.updateUser(user,id);
    }

}
