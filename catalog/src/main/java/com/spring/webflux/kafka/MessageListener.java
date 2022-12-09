package com.spring.webflux.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.spring.webflux.entity.User;

@Component
public class MessageListener {
    
    @KafkaListener(topics = "user", groupId = "foo")
    public void listenGroup(User message){
        System.out.println("Received Message "+ message);
    }
}
