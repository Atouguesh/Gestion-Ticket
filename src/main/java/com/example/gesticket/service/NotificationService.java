package com.example.gesticket.service;

import com.example.gesticket.modele.Ticket;

public interface NotificationService {


    void notifyFormateur(Ticket savedTicket);

    void notifyApprenant(Ticket updatedTicket);
}
