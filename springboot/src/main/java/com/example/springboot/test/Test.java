package com.example.springboot.test;

import java.util.stream.Stream;
/**
* @Description: TODO(自定义注解 依赖注入)
* @Param:
* @return:
* @Author: zcx
* @Date: 2021/1/22 14:32
*/
public class Test {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            MyAutowired annotation = field.getAnnotation(MyAutowired.class);
            if (annotation!=null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object o=null;
                try {
                    o = type.newInstance();
                    field.set(userController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());

    }
}
