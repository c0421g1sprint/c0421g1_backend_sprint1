package com.codegym.emailJava.email;

public interface EmailSender {
    void send(String to, String email);
    String buildEmail(String link);
}
