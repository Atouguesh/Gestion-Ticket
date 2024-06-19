package com.example.gesticket.service;

import com.example.gesticket.modele.Notification;
import com.example.gesticket.modele.Ticket;
import com.example.gesticket.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationServiceImplement implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public Notification createNotification(Ticket ticket) {
        Notification notification = new Notification();
        notification.setContenu("Ticket créé : " + ticket.getTitre());
        notification.setDateCreation(LocalDateTime.now());
        notification.setTicket(ticket);

        return notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(Notification notification) {
        notificationRepository.delete(notification);
    }

    @Override
    public List<Notification> getNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getNotificationsByTicket(Ticket ticket) {
        return notificationRepository.findByTicket(ticket);
    }
}
