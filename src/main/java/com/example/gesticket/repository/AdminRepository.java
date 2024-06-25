package com.example.gesticket.repository;

import com.example.gesticket.modele.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
