package com.springTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-rabbit.xml"})
public class SpringTestRabbitMQ {
    @Resource
    private RabbitTemplate template;
    @Test
    public void sendMessage() throws InterruptedException {
        template.convertAndSend("Hello world!");
        Thread.sleep(1000);
   }
}
