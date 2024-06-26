package com.example.gesticket.repository;

import com.example.gesticket.modele.BasedeConnaissances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasedeConnaissanceRepository extends JpaRepository<BasedeConnaissances ,Long> {
}
