package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog implements ApplicationContextAware{

    private  ApplicationContext applicationContext;

    public Dog() {
        System.out.println("Dog...constructor...");
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog...init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Dog...destroy...");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //拿到ioc容器
        this.applicationContext = applicationContext;
        //System.out.println("ApplicationName--->"+this.applicationContext.getApplicationName());
        //System.out.println("ApplicationName--->"+this.applicationContext.getBean("cat"));
    }
}
