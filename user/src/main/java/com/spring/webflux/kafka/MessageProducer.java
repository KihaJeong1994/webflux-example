package com.spring.webflux.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.spring.webflux.entity.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageProducer {
    
    private final KafkaTemplate<String, User> kafkaTemplate;

    @Value(value = "${message.topic.name}")
    private String topicName;

    public void sendMessage(User user){
        ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(topicName,user);

        future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {

            @Override
            public void onSuccess(SendResult<String, User> result) {
                System.out.println("Sent message="+user+result.getRecordMetadata().offset()+"]");
                
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["+user+"] due to : "+ex.getMessage());
                
            }
            
        });
    }
}
