package com.abc.springcore;

public class EmailMessageService implements  MessageService {

    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void sendMessage() {
        System.out.println("Email Notification sent to : "+email);
    }
}
