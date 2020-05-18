package com.yuxuan66.ioc.test;

import com.yuxuan66.ioc.support.bean.ApplicationContext;

/**
 * @author Sir丶雨轩
 * @date 2020/5/18
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.start("com.yuxuan66");
        Study study = applicationContext.getBean(Study.class);
        study.say();
    }
}
