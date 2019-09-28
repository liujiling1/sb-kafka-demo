package com.sb.kafka.comsumer.controller;

import com.sb.kafka.comsumer.component.TestConsumer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ljl
 * @date : 2019/9/28
 */
@RestController
@RequestMapping("/kafka")
public class TestKafkaConsumerController {

    @RequestMapping("/get")
    public String get(Integer id){

        System.out.println("success-consumer:"+ TestConsumer.store.get(id));
        return "success-concumer:"+TestConsumer.store.get(id);
    }

}

