package com.atguigu.annotation;

import com.atguigu.bean.Blue;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取容器中的所有被扫描到的Bean定义名称
        String[] definitionNames = applicationContext.getBeanDefinitionNames();

        for (String name:definitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        //获取容器中的所有被扫描到的Bean定义名称
        //String[] definitionNames = applicationContext.getBeanDefinitionNames();
        //
        //for (String name:definitionNames) {
        //    System.out.println(name);
        //}
        System.out.println("ioc容器创建完成。");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");

        System.out.println(bean == bean2);
    }

    @Test
    public void test03() {
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }

        //动态获取环境变量的值， Windows 10
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void testImport() {
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        //System.out.println(applicationContext.containsBean("com.atguigu.bean.Blue"));
        //System.out.println(applicationContext.getBeanDefinition("com.atguigu.bean.Blue"));
        System.out.println(bean);

        //工厂Bean获取的是调用getObject创建的对象
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型."+bean2.getClass());
        System.out.println(bean2 == bean3);

        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("bean的类型."+bean4.getClass());
    }

    private void  printBeans( AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}

