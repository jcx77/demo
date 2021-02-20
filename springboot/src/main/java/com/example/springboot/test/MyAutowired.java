package com.example.springboot.test;

import java.lang.annotation.*;
/**
 *
* @Description:TODO()
 * @Retention 声明注解的声明周期
 * @Target:注解的作用目标
 * @Inherited 指示批注类型是自动继承的。
 * @Documented 注解表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的.
 * 但如果声明注解时指定了 @Documented,则它会被 javadoc 之类的工具处理, 所以注解类型信息也会被包括在生成的文档中，是一个标记注解，没有成员)
* @Param:
* @return:
* @Author: zcx
* @Date: 2021/1/22 14:15
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface MyAutowired {

}
