package com.example.artemis.service;


import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Slf4j
public class ArtemisListener implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        try {
            log.info("Received message: " + msg.getBody(String.class));
        } catch (JMSException e) {
            log.error("Error reading queue", e);
        }
    }
}
