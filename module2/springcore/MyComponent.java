package com.abc.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyComponent {

    @Qualifier("emailBean")
    @Autowired
    private MessageService msgService;

    public void setMsgService(MessageService msgService) {
        this.msgService = msgService;
    }

    void sendNotification() {
        msgService.sendMessage();
    }
}
