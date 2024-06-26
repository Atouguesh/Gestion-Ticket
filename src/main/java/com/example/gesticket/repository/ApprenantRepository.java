package com.example.gesticket.repository;

import com.example.gesticket.modele.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    @Query("select a from Apprenant a where  a.id = ?1")
    Apprenant findByName(String name);
}
