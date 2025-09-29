package com.kafkaproducer.produce.service;

import org.springframework.stereotype.Service;

public interface ProducerService {

    void produceMessage(String message);
}
