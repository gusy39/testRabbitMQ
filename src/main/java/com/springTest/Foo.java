package com.springTest;

import org.springframework.stereotype.Component;

/**
 * Foo消费者
 * Created by Administrator on 2016/10/16.
 */

@Component("foo")
public class Foo {
    public void listen(String foo){
        System.out.println("消费者："+foo);
    }
}
