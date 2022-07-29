package com.example.artemis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ArtemisController {

    @Value("${myqueue}")
    private String queue;

    @Autowired
    private JmsTemplate jms;

    @GetMapping("/push")
    public ResponseEntity<String> pushToQueue(@RequestParam String msg) {
        jms.convertAndSend(queue, msg);
        return ResponseEntity.ok("Message pushed to queue: " + msg);
    }
}
