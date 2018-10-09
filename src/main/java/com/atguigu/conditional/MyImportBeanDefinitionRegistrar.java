package com.atguigu.conditional;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

    /**
     * AnnotationMetadata : 当前类的注释信息
     * BeanDefinitionRegistry : BeanDefinition注册类， 把所有需要添加到容器中的bean， 调用
     *  BeanDefinitionRegistry.registerBeanDefinition()方法手工注册进来
     * @param importingClassMetadata
     * @param registry
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean blue = registry.containsBeanDefinition("Blue");
        boolean red = registry.containsBeanDefinition("red");

        if (blue && red) {
            //指定Bean定义信息： 包括Bean的类型，Bean的作用域....
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，指定bean名
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}
