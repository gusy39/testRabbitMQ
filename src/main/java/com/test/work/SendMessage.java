package com.test.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.test.util.ConnectionUtil;

/**
 * 工厂模式
 * Created by Administrator on 2016/10/15.
 */
public class SendMessage {
    private static final String QUEUE_NAME="Hello";
    public static void main(String[] args) throws Exception {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message="Hello world";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println(" [x] Sent '"+message+"'");
        channel.close();
        connection.close();
    }

}
