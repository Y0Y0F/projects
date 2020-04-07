package com.demo.rabbitmq.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class productService  {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            Thread.sleep(1000);
            String text = "hello, 序号: " + i;
            rabbitTemplate.convertAndSend("QUEUE_A", text);
            throw new RuntimeException("手动异常");
        }
    }


}
