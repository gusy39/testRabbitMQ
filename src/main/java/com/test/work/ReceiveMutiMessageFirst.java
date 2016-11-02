package com.test.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.test.util.ConnectionUtil;

/**
 * Created by Administrator on 2016/10/15.
 */
public class ReceiveMutiMessageFirst {
    private static final String QUEUE_NAME = "exchange";

    public static void main(String[] args) throws Exception {
        //获取连接以及信道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, consumer);
        //如果有消息，直接获取到，如果没有，处于等待状态
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
            Thread.sleep(10);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }
    }
}
