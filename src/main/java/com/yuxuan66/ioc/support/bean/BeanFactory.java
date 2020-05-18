package com.yuxuan66.ioc.support.bean;

import java.util.List;

/**
 * @author Sir丶雨轩
 * @date 2020/5/18
 */
public interface BeanFactory {

    /**
     * 根据类型获取一个bean
     * @param type 类型
     * @param <T> 泛型
     * @return bean
     */
    public <T> T getBean(Class<T> type);

    /**
     * 根据名称获取一个bean
     * @param beanName 名称
     * @return bean
     */
    public Object getBean(String beanName);

    /**
     * 根据名称和类型获取一个bean
     * @param beanName 名称
     * @param clazz 类型
     * @param <T> 泛型
     * @return bean
     */
    public <T> T getBean(String beanName,Class<T> clazz);

}
