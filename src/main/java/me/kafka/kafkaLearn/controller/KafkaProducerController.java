package me.kafka.kafkaLearn.controller;

import lombok.RequiredArgsConstructor;
import me.kafka.kafkaLearn.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducerService producerService;

    @PostMapping
    public String publish(@RequestBody String message){
        producerService.sendMessage(message);
        return "Message Published Successsfully";
    }
}
