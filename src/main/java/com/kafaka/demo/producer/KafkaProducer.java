package com.kafaka.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * 生产者
 */
@Component
@EnableScheduling
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 定时发送
     */
    @Scheduled(cron = "0/1 * * * * ?")
    public void send(){
        final String message = UUID.randomUUID().toString();
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("sunwukong", message);
        future.addCallback(o -> System.out.println("send-消息发送成功：" + message),
                throwable -> System.out.println("消息发送失败：" + message));
    }
}
