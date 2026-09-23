package me.kafka.kafkaLearn.controller;

import lombok.RequiredArgsConstructor;
import me.kafka.kafkaLearn.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/many")
    public String sendManyMessage(){
        producerService.sendManyMessages();
        return "Message Published Successsfully";
    }

}
