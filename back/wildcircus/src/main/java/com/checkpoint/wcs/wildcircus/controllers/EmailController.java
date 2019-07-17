package com.checkpoint.wcs.wildcircus.controllers;

import com.checkpoint.wcs.wildcircus.models.Request;
import com.checkpoint.wcs.wildcircus.services.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EmailController {

    public EmailController() {

    }

    @Autowired
    NotificationService notificationService;

    private Logger logger = LoggerFactory.getLogger(EmailController.class);

    @PostMapping("/send-order-email")
    public boolean sendCandidatureEmail(@RequestBody Request request) {

        try {
            notificationService.sendOrder(request);
            return true;
        } catch (MailException e) {
            logger.info("Error sending Email: " + e.getMessage());
            return false;
        }
    }
}
