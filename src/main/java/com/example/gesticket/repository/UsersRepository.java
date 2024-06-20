package com.example.gesticket.repository;

import com.example.gesticket.modele.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
