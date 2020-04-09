package com.kafaka.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = { "sunwukong" })
    public void consumer(ConsumerRecord<String, String> consumerRecord) {
        System.out.println("消息消费--》" + consumerRecord.value());
    }

}
