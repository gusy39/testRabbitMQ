package com.testThreadMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by meidejing on 2016/11/2.
 */
public abstract class EndPoint {
    public Channel channel;
    public Connection connection;
    public String endPointName;
    public EndPoint(String endPointName) throws IOException, TimeoutException {
        this.endPointName=endPointName;
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("192.168.2.178");
        factory.setPort(5672);
        factory.setVirtualHost("/NB");
        factory.setUsername("gusy");
        factory.setPassword("gusy");
        connection=factory.newConnection();
        channel=connection.createChannel();
        channel.queueDeclare(endPointName,false,false,false,null);
    }
    public void close() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}
