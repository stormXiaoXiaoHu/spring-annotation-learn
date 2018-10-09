# spring-annotation-learn 学习spring注解驱动开发

##  概要
spring注解驱动开发主要讲解如下方面知识点：
1. 容器
2. 扩展原理 
3. web

## 具体知识点

###  1.容器
#### AnnotationConfigApplicationContext
#### 组件添加
* @ComponentScan
** value：指定要扫描的包
* excludeFilters = Filter[]: 指定扫描的时候按照什么规则排除那些组件
* includeFilters = Filter[] : 指定扫描的时候只需要包含那些组件
* @Bean
* @Configuration
* @Component
* @Service
* @Controller
* @Repository
* @Conditional
* @Primary
* @Lazy
* @Scope
* @Import
* @ImportSelector
* 工厂模式
#### 组件赋值
#### 组件注入
