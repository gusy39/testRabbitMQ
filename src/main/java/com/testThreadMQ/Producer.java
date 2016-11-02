package com.testThreadMQ;




import org.apache.commons.lang.SerializationUtils;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * Created by meidejing on 2016/11/2.
 */
public class Producer extends EndPoint{
    public Producer(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }
    public void sendMessage(Serializable object) throws IOException {
        byte[] serialize = SerializationUtils.serialize(object);
        channel.basicPublish("",endPointName,null, serialize);
    }
}
