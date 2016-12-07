package com.kumard.service;

public interface EmailService {

    void sendMail(String toAddress, String fromAddress, String content);

}
