package com.atguigu.config;

import com.atguigu.bean.Car;
import com.atguigu.bean.Cat;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的生命周期：
 *          bean的创建-->初始化-->销毁的过程
 * 容器管理bean的生命周期；
 * 我们可以自定义初始化和销毁方法； 容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁
 *
 * 构造（对象创建）
 *     单实例， 在容器启动的时候创建对象
 *     多实例， 在每次获取的时候创建对象
 *
 * BeanPostProcessor.postProcessBeforeInitialization
 *  初始化： 对象创建完成， 并赋值好，调用初始化方法
 * BeanPostProcessor.postProcessAfterInitialization
 *
 * 销毁：
 *         单实例： 容器关闭时候
 *         多实例： 容器不会管理这个bean， 容器不会调用销毁方法
 * 1） 指定初始化和销毁方法
 *    通过@Bean指定init-method="" destroy-method=""
 * 2）通过让Bean实现InitializingBean（定义初始化逻辑)& DisposableBean （定义销毁逻辑）
 * 3） 可以使用 JSR250
 *    @PostConstruct: 在Bean创建完成并且属性赋值完成， 来执行初始化方法
 *    @PreDestroy: 在容器销毁bean之前通知我们进行清理工作
 * 4） BeanPostProcessor[interface] ： bean的后置处理器
 *     postProcessBeforeInitialization:  在初始化之前工作
 *     postProcessAfterInitialization :  在初始化之后工作
 *
 * 遍历得到容器中所有的BeanPostProcessor； 挨个执行beforeInitialization
 * 一旦返回null，跳出for循环， 不会执行后面的BeanPostProcessor.postProcessorBeforeInitialization()
 * BeanPostProcessor原理
 * populateBean(beanName, mbd, instanceWrapper); 给bean进行属性赋值
 *initializeBean {
 *     applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *     invokeInitMethods(beanName, wrappedBean, mbd);  执行自定义初始化
 *     applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *}
 *
 *
 */
@ComponentScan("com.atguigu.bean")
@Configuration
public class MainConfigOfLifCycle {

    //@Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    @Bean
    public Cat cat() {
        return new Cat();
    }

}
