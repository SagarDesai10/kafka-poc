package com.kafkaproducer.produce.controller;

import com.kafkaproducer.produce.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ProducerResource {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/produce")
    public ResponseEntity<String> produceMessage(@RequestBody String message){
        producerService.produceMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }
}
