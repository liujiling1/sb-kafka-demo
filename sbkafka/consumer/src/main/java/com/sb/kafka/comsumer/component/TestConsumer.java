package com.sb.kafka.comsumer.component;

import com.sb.kafka.entity.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : ljl
 * @date : 2019/9/28
 */
@Component
public class TestConsumer {
    public static final Map<Integer,Object> store = new ConcurrentHashMap<>();

    @KafkaListener(topics = "test_topic")
    public void listen (ConsumerRecord<?, ?> record) {
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());

        User user = (User) new User().deSerializer(record.value());

        store.put(user.getId(),user);
    }
}
