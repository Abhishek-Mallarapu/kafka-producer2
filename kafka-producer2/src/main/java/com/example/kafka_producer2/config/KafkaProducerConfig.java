package com.example.kafka_producer2.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig
{

    public NewTopic createTopic()
    {
        return new NewTopic("Abhi-demo",3,(short)1);
    }
}
