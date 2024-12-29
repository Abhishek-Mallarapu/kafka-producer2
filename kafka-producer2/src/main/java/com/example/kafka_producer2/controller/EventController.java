package com.example.kafka_producer2.controller;

import com.example.kafka_producer2.service.KafkaMessagePubllisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePubllisher publlisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {
            for (int i = 0; i <= 100000; i++) {
                publlisher.sendMessageToTopic(message + " : " + i);
            }
            return ResponseEntity.ok("message published successfully ..");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
