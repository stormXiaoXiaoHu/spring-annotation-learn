package com.atguigu.config;

import com.atguigu.bean.Color;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.conditional.LinuxConditional;
import com.atguigu.conditional.MyImportBeanDefinitionRegistrar;
import com.atguigu.conditional.MyImportsSelector;
import com.atguigu.conditional.WindowsConditional;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

//类中组件统一设置： 满足当前条件， 这个类中配置的所有bean注册才能生效
@Conditional({WindowsConditional.class})
@Configuration
@Import({Color.class, Red.class, MyImportsSelector.class, MyImportBeanDefinitionRegistrar.class})  //导入组件， id默认是组件的全类名
public class MainConfig2 {


    //默认是单实例的

    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype
     * ConfigurableBeanFactory#SCOPE_SINGLETON singleton
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
     * @return
     * @Scope： 调整作用域
     * prototype : 多实例的 :  ioc容器启动并不会去调用方法创建对象放在容器中，
     *                         每次获取的时候才会调用方法创建方法。
     * singleton ：单实例的（默认值）: ioc容器启动会调用方法创建对象放到ioc容器中
     *                               以后每次获取就是直接从容器(map.get())中拿.
     * request ： 同一次请求创建一个实例
     * session : 同一个session创建一个实例
     *
     *
     *懒加载：
     *       单实例bean，默认是在容器启动的时候创建对象
     *       懒加载， 容器启动不创建对象， 第一次使用(获取）Bean的创建对象， 并初始化。
     *
     */
    //@Scope("prototype")
    @Lazy
    @Bean
    public Person person() {
        System.out.println("给容器中添加 Person....");
        return new Person("张三",40,"");
    }

    /**
     * @Conditional({Condition}) : 按照一定的条件进行判断， 满足条件给容器中注册Bean
     *
     * 如果系统是windows， 给容器中注册("bill")
     * 如果系统是Linux， 给容器中注册("linus")
     */
    @Conditional({WindowsConditional.class})
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62,"");
    }

    @Conditional({LinuxConditional.class})
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 48,"");
    }

    /**
     * 给容器中注册组件：
     * 1）包扫描 + 组件标记注解（@Controller/@Service/@Repository/@Component）[有局限]
     * 2) @Bean [导入的第三方包里面的组件]
     * 3） @Import [快速给容器中导入一个组件]
     *     1) @Import (要导入到容器中的组件) ： 容器中就会自动注册这个组件， id默认是全类名
     *     2）ImportSelector ：返回需要导入的组件的全类名数组  【spring boot 用得居多】
     *     3) ImportBeanDefinitionRegistrar: 手工注册bean到容器中
     *
     * 4） 使用Spring的提供的FactoryBean（工程Bean）
     *      1) 默认获取到是工厂bean调用getObject创建的对象
     *      2） 获取工厂Bean本身， 我们需要给id前面加一个&
     *          &colorFactoryBean
     */

    //FactoryBean
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
