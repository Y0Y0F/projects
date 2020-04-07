package com.demo.rabbitmq;

import com.demo.rabbitmq.impl.productService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    private productService item;


    @Test
    void contextLoads() throws InterruptedException {
        item.send();
    }

}
