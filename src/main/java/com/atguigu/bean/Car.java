package com.atguigu.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Car {

    public Car() {
        System.out.println("car... constructor...");
    }

    //在对象都创建完成并赋值好之后，调用
    public  void init() {
        System.out.println("car... init...");
    }

    //在容器关闭的时候，调用
    public void destroy() {
        System.out.println("car... destroy...");
    }
}
