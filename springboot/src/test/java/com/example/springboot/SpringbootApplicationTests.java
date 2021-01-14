package com.example.springboot;

import Model.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import util.UUIDHelper;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    ApplicationContext ioc;
    @Test
    void contextLoads() {
        boolean myConfig = ioc.containsBean("myConfig");
        System.out.println(myConfig);
        //Data
    }

}
