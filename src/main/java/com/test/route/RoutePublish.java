package com.test.route;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.test.util.ConnectionUtil;

/**
 * 路由模式
 * Created by Administrator on 2016/10/15.
 */
public class RoutePublish {

    private  final static String EXCHANGE_NAME="test_exchange_direct";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        String message="Hello World!";
        channel.basicPublish(EXCHANGE_NAME,"key",null,message.getBytes());
        System.out.println(" [x] Sent'"+message+"'");
        channel.close();
        connection.close();
    }
}
