package com.yuxuan66.ioc.test;

import com.yuxuan66.ioc.support.annotation.Bean;
import com.yuxuan66.ioc.support.annotation.Inject;

/**
 * @author Sir丶雨轩
 * @date 2020/5/18
 */
@Bean
public class Study {

    @Inject
    private Programme programme;

    public void say(){
        programme.say();
    }
}
