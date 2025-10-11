package com.abc.springcore;

public class SMSMessageService implements  MessageService {

    private String mobile;

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public void sendMessage() {
        System.out.println("SMS Notification sent to "+mobile+" number");
    }
}
