package com.testThreadMQ;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by meidejing on 2016/11/2.
 */
public class ProducerTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Producer producer=new Producer("test");
        int i=0;
        HashMap<String,String> map=null;
        while (i<10000){
            map=new HashMap<String, String>();
            map.put(""+i,"hello_"+i);
            producer.sendMessage(map);
            System.out.println("i:"+i);
            i++;
        }
    }
}
