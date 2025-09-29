package com.kafkaproducer.produce.service.impl;

import com.kafkaproducer.produce.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final Logger logger= LoggerFactory.getLogger(ProducerServiceImpl.class);

    @Autowired
    public ProducerServiceImpl(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    @Override
    public void produceMessage(String message){
        kafkaTemplate.send("test",message);
        logger.info("Message sent successfully");
    }
}
