package LambdaTest;

import Model.Data;
import Model.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Collectors;
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
        //映射 过滤掉指定数据
        Stream<Person> personStream = new Data().getList().stream().filter(person -> person.getLx().equals("1"));

    }
    /**
    * @Description: TODO(排序)sorted
    * @Param: []
    * @return: void
    * @Author: zcx
    * @Date: 2021/1/13 14:29
    */
    @Test
    public void test(){
        new Data().getList().stream().sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);
    }
    /**
    * @Description: TODO(收集) collect 将stream流转换成其他容器
    * @Param: []
    * @return: void
    * @Author: zcx
    * @Date: 2021/1/13 15:58
    */
    @Test
    public void testa(){
        new Data().getList().stream().filter(person -> person.getAge()>1).collect(Collectors.toSet()).forEach(System.out::println);
    }



    /**
    * @Description: TODO(测试性能)
    * @Param: []
    * @return: void
    * @Author: zcx
    * @Date: 2021/1/13 15:15
    */
    @Test
    public void test3(){
        long startTime = System.currentTimeMillis();    //获取开始时间
        new Data().getList().stream().forEach(System.out::print);
        System.out.println();
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println(endTime-startTime);
    }
    @Test
    public void test4(){
        long startTime = System.currentTimeMillis();    //获取开始时间
        new Data().getList().forEach(System.out::print);
        System.out.println();
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println(endTime-startTime);
    }
}
