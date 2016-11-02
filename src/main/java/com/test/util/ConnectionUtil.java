package com.test.util;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * Created by Administrator on 2016/10/15.
 */
public class ConnectionUtil {
public static Connection getConnection() throws Exception{
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/taobao");
        factory.setUsername("taobao");
        factory.setPassword("taobao");
        Connection connection=factory.newConnection();
        return connection;
    }
}
