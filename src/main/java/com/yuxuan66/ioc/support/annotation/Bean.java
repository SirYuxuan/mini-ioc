package com.yuxuan66.ioc.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Sir丶雨轩
 * @date 2020-05-18
 *
 * 元注解
 * 1.@Retention(RetentionPolicy value)  注解的生命周期 default = RetentionPolicy.CLASS
 * RetentionPolicy.SOURCE   表示注解的信息会被编译器抛弃，不会留在class文件中，注解的信息只会留在源文件中
 * RetentionPolicy.CLASS    表示注解的信息被保留在class文件(字节码文件)中当程序编译时，但不会被虚拟机读取在运行的时候
 * RetentionPolicy.RUNTIME  表示注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时
 *
 * 2.@Target(ElementType[] value)  注解的作用域 可同时使用多个 @Target({ElementType.TYPE,ElementType.METHOD})
 * ElementType.TYPE                          接口、类、枚举、注解
 * ElementType.FIELD                         字段、枚举的常量
 * ElementType.METHOD                        方法
 * ElementType.PARAMETER                     方法参数
 * ElementType.CONSTRUCTOR                   构造函数
 * ElementType.LOCAL_VARIABLE                局部变量
 * ElementType.ANNOTATION_TYPE               注解
 * ElementType.PACKAGE                       包
 * ElementType.TYPE_PARAMETER (@since 1.8)   泛型参数
 * ElementType.TYPE_USE (@since 1.8)         使用泛型的地方
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {

    /**
     * beanName
     * @return beanName
     */
    String value() default "";
}
