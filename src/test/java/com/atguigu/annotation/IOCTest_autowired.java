package com.atguigu.annotation;

import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_autowired {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        //BookService BookService = applicationContext.getBean(BookService.class);
        //System.out.println(BookService);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car =  applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        System.out.println("关闭容器...");
        applicationContext.close();
        //BookService.print();

    }
}
