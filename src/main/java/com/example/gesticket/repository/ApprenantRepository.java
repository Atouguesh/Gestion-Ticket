package com.example.gesticket.repository;

import com.example.gesticket.modele.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
}
