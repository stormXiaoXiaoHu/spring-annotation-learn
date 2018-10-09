package com.atguigu.annotation;


import com.atguigu.bean.Yellow;
import com.atguigu.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import javax.sql.DataSource;

public class IOCTest_profile {

    //1. 使用命令行动态参数： 在虚拟机参数位置加载 -Dspring.profiles.active=test
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);

        for (String string : beanNamesForType) {
            System.out.println(string);
        }

        applicationContext.close();

    }

    //2. 代码的方式
    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //1. 创建一个applicationContext
        //2. 设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");
        //3. 注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4. 启动刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);

        for (String string : beanNamesForType) {
            System.out.println(string);
        }

        Yellow yellow = applicationContext.getBean(Yellow.class);
        System.out.println(yellow);

        applicationContext.close();

    }
}
