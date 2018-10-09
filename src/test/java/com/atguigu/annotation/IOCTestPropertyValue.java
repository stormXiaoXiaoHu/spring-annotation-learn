package com.atguigu.annotation;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfLifCycle;
import com.atguigu.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTestPropertyValue {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
    @Test
    public void test01() {
        //1，打印出容器所有注册过的bean
        printBeans(applicationContext);
        System.out.println("IOC容器启动完成");
        System.out.println("=============");

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nikeName");
        System.out.println(property);

        //2，销毁
        applicationContext.close();
    }

    private void  printBeans( AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
