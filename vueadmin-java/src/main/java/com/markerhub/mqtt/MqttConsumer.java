package com.markerhub.mqtt;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;

@Service
public class MqttConsumer {
    @Value("${spring.mqtt.receiveTopics}")
    private String[] receiveTopics;
    public void consumerTopic(Message<?> message){
        // System.out.println(receiveTopics[0]);
        // System.out.println(message.getPayload());
        // System.out.println(message.getHeaders());
        // System.out.println(message.getHeaders().get("mqtt_receivedTopic"));
        
        if(message.getHeaders().get("mqtt_receivedTopic").equals(receiveTopics[0])){
            System.out.println("fist----topic");
            // System.out.println(message.getPayload());
            JSONObject result = JSONObject.parseObject(message.getPayload().toString());
            System.out.println(result);

        }
        if(message.getHeaders().get("mqtt_receivedTopic").equals(receiveTopics[1])){
            // System.out.println(message.getPayload());
            JSONObject result = JSONObject.parseObject(message.getPayload().toString());
            // System.out.println("second---topic");
            System.out.println(result.getString("msg"));

        }
            
       
        
    }
    
}
