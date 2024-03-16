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
        // System.out.println(receiveTopics[1]);
        // System.out.println(message.getPayload());
        // System.out.println(message.getHeaders());
        // System.out.println(message.getHeaders().get("mqtt_receivedTopic"));
        
        // 设备上线
        if(realTopic(message.getHeaders().get("mqtt_receivedTopic").toString()).equals(realTopic(receiveTopics[0]))){
            System.out.println("fist----topic---contend");
            System.out.println(message.getPayload());
            // JSONObject result = JSONObject.parseObject(message.getPayload().toString());
            // System.out.println(result);

        }
        // 设备下线
        if(realTopic(message.getHeaders().get("mqtt_receivedTopic").toString()).equals(realTopic(receiveTopics[1]))){
            System.out.println("second---topic---disconectd");
            
            System.out.println(message.getPayload());

            // JSONObject result = JSONObject.parseObject(message.getPayload().toString());
            // System.out.println(result.getString("msg"));

        }
        // 火焰报警
        if(realTopic(message.getHeaders().get("mqtt_receivedTopic").toString()).equals(realTopic(receiveTopics[2]))){
            System.out.println("second---topic---disconectd");
            
            System.out.println(message.getPayload());

            // JSONObject result = JSONObject.parseObject(message.getPayload().toString());
            // System.out.println(result.getString("msg"));

        }

            
       
        
    }
    
    public String realTopic(String topic){
        int length = topic.split("/").length;
        return topic.split("/")[length-1];

    }
    
}
