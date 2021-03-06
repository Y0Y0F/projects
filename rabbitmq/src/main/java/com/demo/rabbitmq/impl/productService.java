package com.demo.rabbitmq.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class productService  implements RabbitTemplate.ReturnCallback,RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            Thread.sleep(1000);
            String text = "hello, 序号: " + i;
            rabbitTemplate.setReturnCallback(this);
            rabbitTemplate.setConfirmCallback(this);
            rabbitTemplate.convertAndSend("hello",text);
        }
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息[" + correlationData.getId() + "]成功发送到指定ExChange");
        } else {
            System.out.println("消息[" + correlationData.getId() + "]发送到ExChange失败:" + cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("sender return success" + message.toString()+"==="+replyCode+"==="+replyText+"==="+exchange+"routingKey");
    }
}
