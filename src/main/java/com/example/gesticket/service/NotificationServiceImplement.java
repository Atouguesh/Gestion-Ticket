package com.example.gesticket.service;
import com.example.gesticket.EmailSenderService;
import com.example.gesticket.modele.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Service
@AllArgsConstructor
public class NotificationServiceImplement implements NotificationService{


    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private EmailSenderService emailSenderService;

    public void notifyFormateur(Ticket ticket) {
        String destination = "/topic/formateur/" + ticket.getFormateur().getId();
        messagingTemplate.convertAndSend(destination, "Nouveau ticket soumis : " + ticket.getTitre());
        emailSenderService.sendEmail(ticket.getFormateur().getEmail(), "Nouveau ticket soumis", "Un nouveau ticket a été soumis par un apprenant.");
    }

    public void notifyApprenant(Ticket ticket) {
        String destination = "/topic/apprenant/" + ticket.getApprenant().getId();
        messagingTemplate.convertAndSend(destination, "État du ticket mis à jour : " + ticket.getEtat());
        emailSenderService.sendEmail(ticket.getApprenant().getEmail(), "État du ticket mis à jour", "L'état de votre ticket a été mis à jour : " + ticket.getEtat());
    }
}
