package com.atguigu.conditional;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportsSelector implements ImportSelector{

    //返回值： 就是导入到容器中的组件全类名 [ps: 方法不要返回null值, 否则会报空指针异常NullPointerException]

    /**
     * AnnotationMetadata : 当前标注@Import注解的类的所有注解信息
     * @param importingClassMetadata
     * @return
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //importingClassMetadata
        return new String[]{"com.atguigu.bean.Blue","com.atguigu.bean.Yellow"};
    }
}
