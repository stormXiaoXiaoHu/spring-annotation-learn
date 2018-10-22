package com.atguigu.annotation;

import com.atguigu.aop.MathCalculator;
import com.atguigu.config.MainConfigOfAop;
import com.atguigu.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_ext {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

        //发布事件
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")){

        });


        applicationContext.close();

    }
}
