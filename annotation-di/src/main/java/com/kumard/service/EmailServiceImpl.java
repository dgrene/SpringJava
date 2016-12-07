package com.kumard.service;

import org.springframework.stereotype.Component;

@Component("emailService")
public class EmailServiceImpl implements EmailService {

    public void sendMail(String toAddress, String fromAddress, String content) {
        System.out.println("Mail Sent");

    }

}
