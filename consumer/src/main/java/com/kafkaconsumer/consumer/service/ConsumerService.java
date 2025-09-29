package com.kafkaconsumer.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    public ConsumerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "test", groupId = "group1")
    public void consume(String message) {
        logger.info("Consumed message: " + message);
    }

    // Dead latter queue
    @KafkaListener(topics = "test", groupId = "group2")
    public void consume2(String message) {

        if(message.contains("error")){
            kafkaTemplate.send("test.DLQ", message);
        }
    }

    @KafkaListener(topics = "test.DLQ", groupId = "group3")
    public void consumeDLQ(String message) {
        logger.error("Consumed message from DLQ: " + message);
    }
}
