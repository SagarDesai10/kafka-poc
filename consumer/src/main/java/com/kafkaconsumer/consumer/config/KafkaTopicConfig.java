package com.kafkaconsumer.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

// optional

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("test").partitions(3).replicas(1).build();
    }

    @Bean
    public NewTopic testDLQ() {
        return TopicBuilder.name("test.DLQ").partitions(3).replicas(1).build();
    }
}
