package com.example.gesticket.repository;

import com.example.gesticket.modele.Notification;
import com.example.gesticket.modele.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByTicket(Ticket ticket);
}
