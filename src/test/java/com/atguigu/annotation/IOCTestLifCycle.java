package com.atguigu.annotation;

import com.atguigu.config.MainConfigOfLifCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestLifCycle {

    @Test
    public void test01() {
        //1，创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifCycle.class);
        System.out.println("IOC容器启动完成");
        //2，销毁
        //Object bean = applicationContext.getBean("car");
        //Object bean1 = applicationContext.getBean("car");
        applicationContext.close();
    }
}
