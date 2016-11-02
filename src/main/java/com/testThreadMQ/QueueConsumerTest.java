package com.testThreadMQ;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by meidejing on 2016/11/2.
 */
public class QueueConsumerTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        QueueConsumer queueConsumer=new QueueConsumer("test");
        Thread thread=new Thread(queueConsumer);
        for (int i=0;i<4;i++){
            thread.start();
        }
        thread.start();
    }

}
