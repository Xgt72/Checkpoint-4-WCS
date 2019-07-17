package com.checkpoint.wcs.wildcircus.services;

import com.checkpoint.wcs.wildcircus.entities.Customer;
import com.checkpoint.wcs.wildcircus.models.Request;
import com.checkpoint.wcs.wildcircus.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Value("${recipient.email.address}")
    private String recipientEmail;

    @Autowired
    CustomerRepository customerRepository;

    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendOrder(Request request) throws MailAuthenticationException {

        Customer customer = customerRepository.findById(request.getCustomer_id()).get();

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(recipientEmail);
        mail.setSubject(customer.getFirstname() + " " + customer.getLastname() +
                " sent you an order.");
        mail.setText("Lastname: " + customer.getLastname() + "\n" +
                "Firstname: " + customer.getFirstname() + "\n" +
                "Email: " + customer.getEmail() + "\n" + "\n" +
                "Order: " + "\n"
        );
        javaMailSender.send(mail);
    }
}
