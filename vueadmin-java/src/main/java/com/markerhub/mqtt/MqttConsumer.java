package com.markerhub.mqtt;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;

@Service
public class MqttConsumer {
    @Value("${spring.mqtt.receiveTopics}")
    private String[] receiveTopics;
    public void consumerTopic(Message<?> message){
        // System.out.println(receiveTopics[0]);
        // System.out.println(message.getPayload());
        System.out.println(message.getHeaders().get("mqtt_receivedTopic"));
            if(message.getHeaders().get("mqtt_receivedTopic").equals(receiveTopics[0])){
                System.out.println("fisttopic");
            }
            if(message.getHeaders().get("mqtt_receivedTopic").equals(receiveTopics[1])){
                System.out.println("secondtopic");
            }
            
       
        
    }
    
}
