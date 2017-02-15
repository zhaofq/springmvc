package com.java.spring.util.system.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月24日 下午4:17:30
* 类说明
*/
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface SystemServiceLog {  
    String description() default "";  
}  