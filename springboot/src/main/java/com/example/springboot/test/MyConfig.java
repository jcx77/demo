package com.example.springboot.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.UUIDHelper;

/**
 * @Configuration   声明为spring组件
 */
@Configuration
public class MyConfig {
    //@Bean
    public void getData(){
        UUIDHelper.get32UUID();
        System.out.println("已注入");
       // UUIDHelper.get32UUID()
    }
}
