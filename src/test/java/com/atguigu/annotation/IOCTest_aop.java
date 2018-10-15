package com.atguigu.annotation;

import com.atguigu.aop.MathCalculator;
import com.atguigu.bean.Boss;
import com.atguigu.bean.Car;
import com.atguigu.bean.Color;
import com.atguigu.config.MainConfigOfAop;
import com.atguigu.config.MainConfigOfAutowired;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_aop {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

        //不要自己创建对象
        //MathCalculator mathCalculator = new MathCalculator();
        //mathCalculator.div(1,1);

        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,1);

        applicationContext.close();

    }
}
