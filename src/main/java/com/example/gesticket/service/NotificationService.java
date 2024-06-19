package com.example.gesticket.service;

import com.example.gesticket.modele.Notification;
import com.example.gesticket.modele.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NotificationService {
    Notification createNotification(Ticket ticket);
    void deleteNotification(Notification notification);
    List<Notification> getNotifications();
    List<Notification> getNotificationsByTicket(Ticket ticket);



}
