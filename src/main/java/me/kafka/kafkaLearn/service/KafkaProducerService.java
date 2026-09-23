package me.kafka.kafkaLearn.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("rebalance-topic","rebalance-group", message);

        log.info("====================================");
        log.info("Message Sent : {}", message);
        log.info("====================================");
    }

    public void sendManyMessages() {

        for (int i = 1; i <= 20; i++) {

            int partition = i % 2;

            kafkaTemplate.send(
                    "rebalance-topic",
                    partition,
                    null,
                    "Message-" + i
            );

            log.info(
                    "Sent Message-{} to partition {}",
                    i,
                    partition
            );
        }
    }
}
