package com.test.subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.test.util.ConnectionUtil;

/**
 * Created by Administrator on 2016/10/15.
 */

public class Recv2 {

    private final static String QUEUE_NAME = "test_queue_ps_2";

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
        channel.basicQos(1);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME,false,consumer);
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message=new String(delivery.getBody());
            System.out.println(" [x] REceived '"+message+"'");
            Thread.sleep(10);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }
    }

}
