package com.atguigu.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否是Windows系统
public class WindowsConditional implements Condition{

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
