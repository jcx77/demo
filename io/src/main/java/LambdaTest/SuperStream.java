package LambdaTest;

import Model.Data;
import Model.Person;
import org.junit.Test;

import java.util.stream.Stream;

public class SuperStream {
    /**
    * @Description: TODO(stream流筛选与切片)
    * @Param: []
    * @return: void
    * @Author: zcx
    * @Date: 2021/1/12 15:03
    */
    @Test
    public void streamTest() {
        //stream无限流
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        //只读取指定数量数据
        new Data().getList().stream().limit(10).forEach(System.out::println);
        //跳过指定数量
        new Data().getList().stream().skip(2).forEach(System.out::println);
        //去重
        new Data().getList().stream().distinct().forEach(System.out::println);


    }
    @Test
    public void test2() {
        //映射
        new Data().getList().stream().map(Person::getName).filter(s -> s.length()>2).forEach(System.out::println);
    }
}
