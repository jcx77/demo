package LambdaTest;

import Model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateTest {
    public static List<String> fiter(List<String> list, Predicate<String> pre){
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (!pre.test(s)){
                newList.add(s);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");
        List<String> fiter = fiter(list, s -> s.contains("1"));
        fiter.forEach(s -> System.out.println(s));

    }
    @Test
    public void test(){
        Function<Person,String> f0 = p -> p.getName();
        //简化
        Function<Person,String> f = Person :: getName;
        System.out.println(f.apply(new Person("s")));
    }
}
