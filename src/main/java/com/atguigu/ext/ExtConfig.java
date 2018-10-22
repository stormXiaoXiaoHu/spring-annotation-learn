package com.atguigu.ext;


import com.atguigu.bean.Blue;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理：
 *    BeanPostProcessor： bean后置处理器， bean创建对象初始化前后进行拦截工作的
 * 1、BeanFactoryPostProcessor： beanFactory后置处理器
 *   在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；
 *   所有的bean定义已经保存加载到beanFactory， 但是bean的实例还未创建
 *
 * BeanFactoryPostProcessor原理：
 *   1)、ioc容器创建对象
 *   2）、 invokeBeanFactoryPostProcessors(beanFactory); 执行beanFactoryPostProcessor
 *         如何找到所有的beanFactoryPostProcessor并执行他们的方法：
 *         1、 直接在BeanFactory找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *         2、在初始化创建其他组件前面执行
 *
 * 2、 BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      postProcessBeanDefinitionRegistry();
 *     在所有bean定义信息将要被加载， bean实例还未创建的；
 *
 *     优先于 BeanFactoryPostProcessor 执行
 *     利用 BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件
 *
 * BeanDefinitionRegistryPostProcessor原理：
 *   1)、ioc创建对象
 *   2）、 refresh-->invokeBeanFactoryPostProcessors(beanFactory)
 *   3）、 从容器中获取到所有BeanDefinitionRegistryPostProcessor组件
 *         1、 依次触发所有的postProcessBeanDefinitionRegistry（）方法
 *         2、 再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor
 *
 *   4)再来从容器找到BeanFactoryPostProcessor组件，然后依次触发postProcessBeanFactory()方法
 *
 * 3、 ApplicationListener ：监听容器中发布的事件， 事件驱动模型开发；
 *     ApplicationListener<E extends ApplicationEvent> extends EventListener
 *       监听ApplicationEvent 及其下面的子事件：
 *
 *    步骤：
 *         1）、写一个监听器来监听某个事件（ApplicationEvent及其子类）
 *              @EventListerner；
 *              原理： 使用EventListenerMethodProcessor处理器来解析方法上的@EventListerner
 *
 *         2）、 把监听器加入到容器
 *         3） 只有容器中相关事件的发布， 我们就能监听到这个事件：
 *             ContextRefreshedEvent：容器刷新完成（所有bean都完全创建）会发布这个事件
 *             ContextClosedEvent： 关闭容器会发布这个事件
 *
 *         4）、如何发布一个事件？
 *               applicationContext.publishEvent();
 *   原理：
 *   ContextRefreshedEvent、IOCTest_ext$1[source=我发布的事件]、ContextClosedEvent
 *  1、ContextRefreshedEvent事件，
 *     1）、容器创建对象： refresh()
 *     2）、finishRefresh(); 容器刷新完成会发布ContextRefreshedEvent
 *  2、发布自己的事件
 *  3、容器关闭会发布ContextClosedEvent
 *
 * 【事件发布流程】
 *  3)、 publishEvent(new ContextRefreshedEvent(this));
 *            a、获取事件的多播器（派发器）getApplicationEventMulticaster().multicastEvent();
 *            b、 multicastEvent（）派发事件
 *            c、 获取到所有的ApplicationListeners:
 *                for (final ApplicationListener<?> listener : getApplicationListeners(event, type))
 *                I、如果有Executor， 可以支持使用Executor 进行异步派发
 *                    Executor executor = getTaskExecutor();
 *                II、 否则，同步的方式执行listener方法， invokeListener(listener, event);
 *                     拿到listener回调onApplicationEvent
 *
 *   【事件多播器（派发器）】
 *   1）、容器创建对象， refresh（）
 *   2)、 initApplicationEventMulticaster（）； 初始化 initApplicationEventMulticaster；
 *         a、先去容器找有没有 id="applicationEventMulticaster"的组件，
 *         b、如果没有this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *            并且加入到容器中， 我们就可以在其他组件要派发事件，自动注入这个applicationEventMulticaster
 *
 * 【容器中有哪些监听器】
 *  1）、容器创建对象，refresh();
 *  2）、registerListeners();
 *      从容器中拿到所有的监听器， 把她们注册到applicationEventMulticaster中，
 *      String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *      //将listener注册到ApplicationEventMulticaster中
 *      getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *
 *
 *SmartInitializingSingleton原理： -> afterSingletonsInstantiated();
 *  1）、 ioc容器创建对象并refresh()；
 *  2）、 finishBeanFactoryInitialization（beanFactory)； 初始化剩下的单实例bean
 *        a、先创建所有的单实例bean； getBean();
 *        b、获取所有创建好的单实例bean， 判断是否是SmartInitializingSingleton类型的；
 *           如果是就调用afterSingletonsInstantiated（）；
 *
 *
 *
 */

@ComponentScan("com.atguigu.ext")
@Configuration
public class ExtConfig {
    @Bean
    public Blue blue() {
        return new Blue();
    }
}
