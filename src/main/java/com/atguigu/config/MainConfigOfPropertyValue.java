package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//使用@PropertySource读取到外部配置文件中的K/V保存到运行的环境变量中；
// 加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource(value = {"classpath:/person.properties"}, encoding = "GBK")
@Configuration
public class MainConfigOfPropertyValue {

    @Bean
    public Person person () {
        return new Person();
    }
}
