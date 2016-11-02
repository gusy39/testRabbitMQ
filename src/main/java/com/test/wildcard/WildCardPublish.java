package com.test.wildcard;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.test.util.ConnectionUtil;

/**
 * Created by Administrator on 2016/10/15.
 */
public class WildCardPublish {
    private final static String EXCHANGE_NAME = "test_exchange_topic";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
        String message="Hello World";
        channel.basicPublish(EXCHANGE_NAME,"item.save",null,message.getBytes());
        System.out.println("[x] Sent '"+message+"'");
        channel.close();
        connection.close();
    }
}
