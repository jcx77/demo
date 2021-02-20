package com.proxy;

import com.proxy.test.MyProxy;
import com.proxy.test.MyProxyImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//aop动态代理
@SpringBootTest
class ProxyApplicationTests {
    //@Autowired
    MyProxy pro=new MyProxyImpl();
    //Object obj;
    @Test
    void contextLoads() {
        ClassLoader classLoader = pro.getClass().getClassLoader();
        Class[] inf={MyProxy.class};
        InvocationHandler h= (proxy, method, args) -> {
            System.out.println(method.getName());
            Object result = method.invoke(pro, args);
            System.out.println("ok");
            return result;
        };
        MyProxy o = (MyProxy) Proxy.newProxyInstance(classLoader, inf, h);
        o.add();
    }


}
