# spring-annotation-learn 学习spring注解驱动开发

##  概要
spring注解驱动开发主要讲解如下方面知识点：
1. 容器
2. 扩展原理 
3. web

## 具体知识点

###  1.容器

    AnnotationConfigApplicationContext

#### 组件添加
* @ComponentScan
   1. value：指定要扫描的包
   2. excludeFilters = Filter[]: 指定扫描的时候按照什么规则排除那些组件
   3. includeFilters = Filter[] : 指定扫描的时候只需要包含那些组件，use-default-filters: 默认是true, false表示：禁用默认规则，只包含才生效
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
* @Value
* @Autowied： 
  1. @Qualifier
  2. 其他方式： @Resource（JSR250）、@Inject(JSR330， 需要导入 javax.inject)
* @PropertySource
* @PropertySources
* @Profiles
  1. Enviroment
  2. -Dspring.profiles.active=test

#### 组件注入
* 方法参数
* 构造器注入
* ApplicationContextAware-->ApplicationContextAwareProcessor

#### AOP
#### 声明式事务
