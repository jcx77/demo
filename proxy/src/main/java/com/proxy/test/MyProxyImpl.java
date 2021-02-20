package com.proxy.test;
/**
* @Description: TODO(aop 动态代理 实现日志)
* @Param:
* @return:
* @Author: zcx
* @Date: 2021/1/14 15:44
*/
public class MyProxyImpl implements MyProxy{
    @Override
    public void add() {
        System.out.println("添加");
    }

    @Override
    public void get() {
        System.out.println("获取");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }
}
