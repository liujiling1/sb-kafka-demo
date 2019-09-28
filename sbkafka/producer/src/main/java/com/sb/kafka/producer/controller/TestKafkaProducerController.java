package com.sb.kafka.producer.controller;

import com.sb.kafka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : ljl
 * @date : 2019/9/28
 */
@RestController
@RequestMapping("/kafka")
public class TestKafkaProducerController {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    public static AtomicInteger ATOMIC_ID = new AtomicInteger();

    @RequestMapping("/send")
    public String send(String msg){

        User user = new User();
        user.setId(ATOMIC_ID.getAndIncrement());
        user.setName(msg);
        user.setAge(18+user.getId());

        kafkaTemplate.send("test_topic", user.serializer());

        System.out.println("success-produce:"+user.serializer());
        return "success-produce:"+msg;
    }

}

